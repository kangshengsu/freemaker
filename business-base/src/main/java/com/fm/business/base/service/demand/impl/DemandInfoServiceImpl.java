/**
 * @filename:DemandInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.enums.BudgetType;
import com.fm.business.base.enums.DeliveryType;
import com.fm.business.base.enums.DemandAttestationType;
import com.fm.business.base.enums.DemandStatus;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:(需求服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("demandInfoService")
public class DemandInfoServiceImpl extends AuditBaseService<IDemandInfoMapper, DemandInfo> implements IDemandInfoService {

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IDemandProductionRelationService iDemandProductionRelationService;

    @Override
    protected Page<DemandInfo> toPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<DemandInfo> mybatisPlusPage) {
        Page<DemandInfo> demandInfoPage = super.toPage(mybatisPlusPage);
        if (demandInfoPage.getData() != null && !demandInfoPage.getData().isEmpty()) {
            //补全信息
            fillOtherInfo(demandInfoPage.getData());
        }
        return demandInfoPage;
    }

    /**
     * 补全数据
     */
    private void fillOtherInfo(Collection<DemandInfo> demandInfos) {

        if (CollectionUtils.isEmpty(demandInfos)) {
            return;
        }

        Set<Long> employerIds = new HashSet<>();
        Set<Long> jobCateIds = new HashSet<>();

        demandInfos.forEach(demandInfo -> {
            employerIds.add(demandInfo.getEmployerId());
            jobCateIds.add(demandInfo.getJobCateId());
        });

        Map<Long, EmployerInfo> employerInfMap = employerInfoService.getByIds(employerIds)
                .stream().collect(Collectors.toMap(EmployerInfo::getId, Function.identity(), (v1, v2) -> v2));

        Map<Long, BdJobCate> postCateMap = bdJobCateService.getByIds(jobCateIds)
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));


        demandInfos.forEach(demandInfo -> {
            demandInfo.setStatusName(DemandStatus.get(demandInfo.getStatus()).getName());
            demandInfo.setDeliveryTypeName(DeliveryType.getNameByCode(demandInfo.getDeliveryType()));
            demandInfo.setBudgetTypeName(BudgetType.getNameByCode(demandInfo.getBudgetType()));
            if (employerInfMap.containsKey(demandInfo.getEmployerId())) {
                demandInfo.setEmployerInfo(employerInfMap.get(demandInfo.getEmployerId()));
            }
            if (postCateMap.containsKey(demandInfo.getJobCateId())) {
                demandInfo.setBdJobCate(postCateMap.get(demandInfo.getJobCateId()));
            }
        });


    }


    @Override
    public int updateRecommendCountById(Long id, Integer recommendCount) {
        DemandInfo demandInfo = new DemandInfo();
        demandInfo.setId(id);
        demandInfo.setRecommendCount(recommendCount);
        return this.getBaseMapper().updateById(demandInfo);
    }

    @Override
    public Integer getDemandCountByStatus(Long employerId, Integer status) {
        return getBaseMapper().selectCount(
                getQueryWrapper().lambda()
                        .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(DemandInfo::getEmployerId, employerId)
                        .eq(DemandInfo::getStatus, status));
    }

    @Override
    public Page<DemandInfo> gePageByEmployerId(Integer currentPage, Integer pageSize, Long employerId, Integer status, List<Long> demandProductionRelationIds) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(DemandInfo::getEmployerId, employerId)
                                .eq(status != 0, DemandInfo::getStatus, status)
                                .or().in(!CollectionUtils.isEmpty(demandProductionRelationIds), DemandInfo::getId, demandProductionRelationIds)
                                .eq(!CollectionUtils.isEmpty(demandProductionRelationIds),DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(!CollectionUtils.isEmpty(demandProductionRelationIds)&&status != 0, DemandInfo::getStatus, status)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public Page<DemandInfo> gePageByStatusJobCateId(Integer currentPage, Integer pageSize, Long employerId, Integer status, Integer jobCateId) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(status != 0, DemandInfo::getStatus, status)
                                .eq(jobCateId != null, DemandInfo::getJobCateId, jobCateId)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public int updateStatusByCode(String code, Integer status) {
        if (DemandStatus.get(status) == null) {
            return 0;
        }
        UpdateWrapper<DemandInfo> updateWrapper = Wrappers.update();
        updateWrapper.set("status", status).eq("code", code);
        return this.getBaseMapper().update(null, updateWrapper);
    }

    @Override
    public int updateByCode(DemandInfo demandInfo) {
        UpdateWrapper<DemandInfo> updateWrapper = Wrappers.update();
        updateWrapper.eq("code", demandInfo.getCode());
        return this.getBaseMapper().update(demandInfo, updateWrapper);
    }

    @Override
    public DemandInfo getByCode(String code) {
        QueryWrapper<DemandInfo> queryWrapper = getQueryWrapper().eq("code", code);
        DemandInfo demandInfo = this.getBaseMapper().selectOne(queryWrapper);
        fill(demandInfo);
        return demandInfo;
    }

    private void fill(DemandInfo demandInfo) {
        if(demandInfo == null){
            return;
        }
        demandInfo.setEmployerInfo(employerInfoService.getById(demandInfo.getEmployerId()));
    }

    @Override
    protected void beforeUpdate(DemandInfo model) {
        super.beforeUpdate(model);
        if (model.getJobCateId() != null) {
            BdJobCate bdJobCate = bdJobCateService.get(model.getJobCateId());
            model.setCateTreeCode(bdJobCate != null ? bdJobCate.getTreeCode() : "");
        }
    }

    @Override
    protected void beforeSave(DemandInfo model) {
        super.beforeSave(model);
        if (StringUtils.isEmpty(model.getCode())) {
            //生成code
            model.setCode(CodeUtil.generateNewCode2yyMMddHH());
        }
        if (model.getStatus() == null) {
            model.setStatus(DemandStatus.RELEASE.getCode());
        }
        if (model.getJobCateId() != null) {
            BdJobCate bdJobCate = bdJobCateService.get(model.getJobCateId());
            model.setCateTreeCode(bdJobCate != null ? bdJobCate.getTreeCode() : "");
        }
    }

    /**
     * 通过名字或电话查找数据 最多返回10条
     *
     * @param str
     * @return
     */
    @Override
    public List<DemandInfo> findDemandInfoLikeNameOrCode(String str) {

        if (StringUtils.isEmpty(str)) {
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(DemandInfo.class)
                .like(DemandInfo::getCode, str)
                .or()
                .like(DemandInfo::getSummarize, str)
                .last("limit 10"));
    }

    @Override
    public Page<DemandInfo> getPageDemandInfo(List<Long> demandId,Integer currentPage,Integer pageSize,Integer demandStatus) {
        if (CollectionUtils.isEmpty(demandId)) {
            return new PageInfo<>();
        }
        if (demandStatus == DemandStatus.RELEASE.getCode()) {
            return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getStatus,DemandStatus.RELEASE.getCode()).in(DemandInfo::getId,demandId)));
        }else if (demandStatus == DemandStatus.CANCEL.getCode()){
            return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                    Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getStatus,DemandStatus.CANCEL.getCode()).in(DemandInfo::getId,demandId)));
        }else{
            return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                    Wrappers.lambdaQuery(DemandInfo.class).in(DemandInfo::getId,demandId)));
        }


    }
    public Page<DemandInfo> getPageByEmployerId(Integer currentPage, Integer pageSize, Integer status, Long employerId) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(status != 0, DemandInfo::getStatus, status)
                                .eq(DemandInfo::getEmployerId, employerId)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public Page<DemandInfo> getPageByDemandStatus(Integer currentPage, Integer pageSize, Integer status, List<Long> demandProductionRelationIds) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .in(!CollectionUtils.isEmpty(demandProductionRelationIds), DemandInfo::getId, demandProductionRelationIds)
                                .eq(!CollectionUtils.isEmpty(demandProductionRelationIds),DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(!CollectionUtils.isEmpty(demandProductionRelationIds)&&status != 0, DemandInfo::getStatus, status)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public Integer getDemandCountByStatus(Long employerId, Integer status, List<Long> demandProductionRelationIds) {
        return getBaseMapper().selectCount(
                getQueryWrapper().lambda()
                        .in(!CollectionUtils.isEmpty(demandProductionRelationIds), DemandInfo::getId, demandProductionRelationIds)
                        .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(DemandInfo::getStatus, status));
    }

    @Override
    public Integer getDemandClosedCount(List<Long> demandId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getStatus,DemandStatus.CANCEL.getCode()).in(DemandInfo::getId,demandId)).size();

    }

    @Override
    public Integer getOpenedDemandCount(List<Long> demandId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getStatus, DemandStatus.RELEASE.getCode()).in(DemandInfo::getId,demandId)).size();
    }

    @Override
    public Page<DemandInfo> getDemandByKeyword(String keyword, Integer currentPage, Integer pageSize) {
//        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DemandInfo> demandInfoPage = getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
//                Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getStatus, DemandStatus.RELEASE.getCode()).eq(DemandInfo::getAttestation, DemandAttestationType.YES_ATTESTATION.getCode()).like(DemandInfo::getSummarize, keyword).or().like(DemandInfo::getDescription, keyword));
        QueryWrapper<DemandInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("status", DemandStatus.RELEASE.getCode());
        wrapper.eq("attestation", DemandAttestationType.YES_ATTESTATION.getCode());
        wrapper.and(w -> w.like("summarize", keyword).or()
                .like("description", keyword));

        return toPage( getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize), wrapper));
    }
}
