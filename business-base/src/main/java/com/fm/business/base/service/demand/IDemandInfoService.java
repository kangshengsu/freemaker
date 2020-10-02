/**
 * @filename:DemandInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(需求服务层)
 * @version: V1.0
 * @author: LiuDuo
 */
public interface IDemandInfoService extends Service<DemandInfo> {

    /**
     * 根据需求id更新推荐人数
     *
     * @param id
     * @param recommendCount
     */
    int updateRecommendCountById(Long id, Integer recommendCount);

    /**
     * 获取不同状态下的需求总数
     *
     * @param employerId
     * @param status
     * @return
     */
    Integer getDemandCountByStatus(Long employerId, Integer status);

    /**
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @param employerId  雇主ID
     * @return 需求编码
     */
    Page<DemandInfo> gePageByEmployerId(Integer currentPage, Integer pageSize, Long employerId, Integer status);

    /**
     * 根据需求编码更新需求状态
     *
     * @param code
     * @param status
     * @return
     */
    int updateStatusByCode(String code, Integer status);

    int updateByCode(DemandInfo demandInfo);

    DemandInfo getByCode(String code);
}
