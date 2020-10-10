/**
 * @filename:DemandProductionRelationService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.production.ProductionInfo;
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
    void recommend( Long demandId,List<Long> productionIds);

    int deleteByIds(List<Long> ids);

}
