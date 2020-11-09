/**
 * @filename:DemandProductionRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandProductionRelationMapper;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.RecommendProduction;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.constants.SymbolConstants;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.SubModelCompareResult;
import com.fm.framework.core.utils.UpdateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:(需求作品关系服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("demandProductionRelationService")
public class DemandProductionRelationServiceImpl extends AuditBaseService<IDemandProductionRelationMapper, DemandProductionRelation> implements IDemandProductionRelationService {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @Autowired
    private IDemandInfoService iDemandInfoService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private IEvaluationInfoService iEvaluationInfoService;

    @Override
    public List<DemandProductionRelation> getByDemandId(Long demandId) {
        if (demandId == null) {
            return Collections.EMPTY_LIST;
        }
        return getBaseMapper().selectList(Wrappers.lambdaQuery(DemandProductionRelation.class).eq(DemandProductionRelation::getDemandId, demandId));
    }

    @Override
    public List<RecommendProduction> getDemandProductionsByDemandId(Long demandId) {
        if (demandId == null) {
            return Collections.EMPTY_LIST;
        }

        List<DemandProductionRelation> demandProductionRelations = demandProductionRelationService.getByDemandId(demandId);
        if (CollectionUtils.isEmpty(demandProductionRelations)) {
            return Collections.EMPTY_LIST;
        }
        List<Long> productionIds = demandProductionRelations.stream().map(DemandProductionRelation::getProductionId).collect(Collectors.toList());

        List<ProductionInfo> productionInfos = productionInfoService.getFullInfo(productionIds);
        List<RecommendProduction> recommendProductions = new ArrayList<>(productionInfos.size());
        productionInfos.forEach(productionInfo -> {
            RecommendProduction recommendProduction = new RecommendProduction();
            BeanUtils.copyProperties(productionInfo,recommendProduction);
            recommendProduction.setOverallEvaluation(iEvaluationInfoService.findOverallEvaluationByCateAndFreelancer(recommendProduction.getJobCateId(),
                    recommendProduction.getFreelancerId()));
            recommendProductions.add(recommendProduction);

        });

        return recommendProductions;
    }


    @Override
    @Transactional
    public void recommend(Long demandId, List<Long> productionIds, Integer status) {
        List<DemandProductionRelation> oldRelations = demandProductionRelationService.getByDemandId(demandId);
        List<DemandProductionRelation> newRelations = productionIds.stream().map(productionId -> {
            DemandProductionRelation demandProductionRelation = new DemandProductionRelation();
            demandProductionRelation.setDemandId(demandId);
            demandProductionRelation.setStatus(status);
            demandProductionRelation.setProductionId(productionId);
            return demandProductionRelation;
        }).collect(Collectors.toList());

        //获取新老字段差异
        SubModelCompareResult<DemandProductionRelation> subModelCompareResult = UpdateUtils.compare(newRelations, oldRelations,
                demandProductionRelation -> demandProductionRelation.getDemandId() + SymbolConstants.UNDERLINE + demandProductionRelation.getProductionId(),
                (old, newT) -> old.getDemandId().equals(newT.getDemandId()) && old.getProductionId().equals(newT.getProductionId()));

        //插入
        if (!CollectionUtils.isEmpty(newRelations)) {
            demandProductionRelationService.save(newRelations);
        }

        //删除
        if (!CollectionUtils.isEmpty(oldRelations)) {
            List<Long> deleteIds = oldRelations.stream().map(DemandProductionRelation::getId).collect(Collectors.toList());
            demandProductionRelationService.deleteByIds(deleteIds);
        }

        iDemandInfoService.updateRecommendCountById(demandId,productionIds.size());


    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return getBaseMapper().deleteBatchIds(ids);
    }

    @Override
    public List<DemandProductionRelation> findRecommend(List<Long> productionIds, Long demandId) {
        Wrapper queryWrapper = Wrappers.lambdaQuery(DemandProductionRelation.class).in(DemandProductionRelation::getProductionId,productionIds)
                .eq(DemandProductionRelation::getDemandId,demandId)
                .eq(DemandProductionRelation::getIsDelete,0);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public List<DemandProductionRelation> findAllRecommend(List<Long> productionIds) {
        Wrapper queryWrapper = Wrappers.lambdaQuery(DemandProductionRelation.class).in(DemandProductionRelation::getProductionId,productionIds)
                .eq(DemandProductionRelation::getIsDelete,0);
        return getBaseMapper().selectList(queryWrapper);
    }


}
