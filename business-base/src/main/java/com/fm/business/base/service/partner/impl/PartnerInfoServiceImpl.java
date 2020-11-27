package com.fm.business.base.service.partner.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fm.business.base.dao.partner.PartnerInfoMapper;
import com.fm.business.base.enums.DistributionStatus;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.partner.PartnerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@Service("partnerInfoService")
public class PartnerInfoServiceImpl extends AuditBaseService<PartnerInfoMapper, PartnerInfo> implements PartnerInfoService {

    @Autowired
    private ISysUserService iSysUserService;

    @Override
    public List<PartnerInfo> findNotExistProduction(List<Long> ids) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct freelancer_Id")
                .notIn("freelancer_Id", ids);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean setPartner(List<Long> list, Long id) {
        UpdateWrapper<PartnerInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("belong_id",id).in("freelancer_id", list);
        updateWrapper.set("distribution_status", DistributionStatus.YES_DISTRIBUTION.getCode()).in("freelancer_id", list);
        return super.update(updateWrapper);
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

        partnerInfos.forEach(partnerInfo -> {
            if(partnerInfo.getBelongId() != null){
                SysUser sysUser = iSysUserService.get(partnerInfo.getBelongId());
                partnerInfo.setBelongIdName(sysUser.getName());
            }
            if(partnerInfo.getReferrerId() != null){
                SysUser sysUser = iSysUserService.get(partnerInfo.getReferrerId());
                partnerInfo.setReferrerIdName(sysUser.getName());
            }
        });

    }
}
