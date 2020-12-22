/**
 * @filename:DemandProductionRelationService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.production.RecommendProduction;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(需求作品关系服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IDemandProductionRelationService extends Service<DemandProductionRelation> {

    /**
     * 根据需求获取已经推荐的作品
     * @param demandId
     * @return
     */
    List<DemandProductionRelation> getByDemandId(Long demandId);

    /**
     * 根据需求获取推荐作品信息
     * @param demandId
     * @return
     */
    List<RecommendProduction> getDemandProductionsByDemandId(Long demandId);

    /**
     * 推荐
     */
    void recommend( Long demandId, List<Long> productionIds, Integer status);

    int deleteByIds(List<Long> ids);

    /**
     * 查询某个需求是否被推荐过
     * @param productionIds
     * @param demandId
     * @return
     */
    List<DemandProductionRelation> findRecommend(List<Long>productionIds, Long demandId);

    /**
     * 查询我的作品被推荐过的所有需求
     * @param productionIds
     * @return
     */
    List<DemandProductionRelation> findAllRecommend(List<Long>productionIds);

    /**
     * 根据状态查询我的作品被推荐过的所有需求
     * @param productionIds
     * @return
     */
    List<DemandProductionRelation> findAllRecommendByStatus(List<Long>productionIds, Integer status);






}
