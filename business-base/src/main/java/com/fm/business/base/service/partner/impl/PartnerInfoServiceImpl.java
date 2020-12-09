package com.fm.business.base.service.partner.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fm.business.base.dao.partner.PartnerInfoMapper;
import com.fm.business.base.enums.DistributionStatus;
import com.fm.business.base.enums.SettlementStatus;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.partner.PartnerInfoService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service("partnerInfoService")
public class PartnerInfoServiceImpl extends AuditBaseService<PartnerInfoMapper, PartnerInfo> implements PartnerInfoService {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IUserService iUserService;

    @Override
    public List<PartnerInfo> findNotExistProduction(List<Long> ids) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct freelancer_Id")
                .notIn("freelancer_Id", ids);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public List<PartnerInfo> findByBelongId(Long id) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("belong_id", id);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public List<PartnerInfo> findByBelongIds(List<Long> ids) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("belong_id", ids);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public List<PartnerInfo> findByFreelancerIds(Set<Long> ids) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("freelancer_id", ids);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean settlement(List<Long> ids) {
        UpdateWrapper<PartnerInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("settlement_id", Context.getCurrUserId()).in("freelancer_id", ids);
        updateWrapper.set("settlement_time", new Date()).in("freelancer_id", ids);
        updateWrapper.set("settlement_status", SettlementStatus.SETTLED.getCode()).in("freelancer_id", ids);
        return super.update(updateWrapper);
    }

    @Override
    public boolean distribution(List<Long> list, Long id) {
        UpdateWrapper<PartnerInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("belong_id",id).in("freelancer_id", list);
        updateWrapper.set("distribution_id",Context.getCurrUserId()).in("freelancer_id", list);
        updateWrapper.set("distribution_time",new Date()).in("freelancer_id", list);
        updateWrapper.set("distribution_status", DistributionStatus.YES_DISTRIBUTION.getCode()).in("freelancer_id", list);
        return super.update(updateWrapper);
    }

    @Override
    protected Page<PartnerInfo> toPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<PartnerInfo> mybatisPlusPage) {
        Page<PartnerInfo> partnerInfoPage = super.toPage(mybatisPlusPage);
        if (partnerInfoPage.getData() != null && !partnerInfoPage.getData().isEmpty()) {
            //补全信息
            fillPartnerInfoRelation(partnerInfoPage.getData());
        }
        return partnerInfoPage;
    }

    /**
     * 补全数据
     *
     */
    private void fillPartnerInfoRelation(Collection<PartnerInfo> partnerInfos) {

        if (CollectionUtils.isEmpty(partnerInfos)) {
            return;
        }

        Set<Long> belongIds = new HashSet<>();
        Set<Long> referrerIds = new HashSet<>();
        Set<Long> settlementIds = new HashSet<>();
        Set<Long> distributionIds = new HashSet<>();

        partnerInfos.forEach(partnerInfo -> {
            belongIds.add(partnerInfo.getBelongId());
            referrerIds.add(partnerInfo.getReferrerId());
            settlementIds.add(partnerInfo.getSettlementId());
            distributionIds.add(partnerInfo.getDistributionId());
        });

        Map<Long, SysUser> belongMap = iSysUserService.getByIds(belongIds)
                .stream().collect(Collectors.toMap(SysUser::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, SysUser> referrerMap = iSysUserService.getByIds(referrerIds)
                .stream().collect(Collectors.toMap(SysUser::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, User> settlementMap = iUserService.getByIds(settlementIds)
                .stream().collect(Collectors.toMap(User::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, User> distributionMap = iUserService.getByIds(distributionIds)
                .stream().collect(Collectors.toMap(User::getId, Function.identity(), (v1, v2) -> v2));

        partnerInfos.forEach(partnerInfo -> {
            if (belongMap.containsKey(partnerInfo.getBelongId())) {
                if(belongMap.get(partnerInfo.getBelongId()) != null){
                    SysUser sysUser = iSysUserService.get(belongMap.get(partnerInfo.getBelongId()).getId());
                    partnerInfo.setBelongIdName(sysUser.getName());
                }
            }
            if (referrerMap.containsKey(partnerInfo.getReferrerId())) {
                if(referrerMap.get(partnerInfo.getReferrerId()) != null){
                    SysUser sysUser = iSysUserService.get(referrerMap.get(partnerInfo.getReferrerId()).getId());
                    partnerInfo.setReferrerIdName(sysUser.getName());
                }
            }
            if (settlementMap.containsKey(partnerInfo.getSettlementId())) {
                if(settlementMap.get(partnerInfo.getSettlementId()) != null){
                    User user = iUserService.get(settlementMap.get(partnerInfo.getSettlementId()).getId());
                    partnerInfo.setSettlementIdName(user.getName());
                }
            }
            if (distributionMap.containsKey(partnerInfo.getDistributionId())) {
                if(distributionMap.get(partnerInfo.getDistributionId()) != null){
                    User user = iUserService.get(distributionMap.get(partnerInfo.getDistributionId()).getId());
                    partnerInfo.setDistributionIdName(user.getName());
                }
            }
        });

    }
}
