/**
 * @filename:DemandInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandInfo;
import com.fm.framework.core.service.Service;

/**
 * @Description:(需求服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IDemandInfoService extends Service<DemandInfo> {

    /**
     * 根据需求id更新推荐人数
     * @param id
     * @param recommendCount
     */
    int updateRecommendCountById(Long id,Integer recommendCount);

    /**
     * 根据需求编码更新需求状态
     * @param code
     * @param status
     * @return
     */
    int updateStatusByCode(String code,Integer status);

    int updateByCode(DemandInfo demandInfo);

    DemandInfo getByCode(String code);
}
