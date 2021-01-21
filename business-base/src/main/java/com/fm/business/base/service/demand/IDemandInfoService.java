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
    Page<DemandInfo> gePageByEmployerId(Integer currentPage, Integer pageSize, Long employerId, Integer status, List<Long> demandProductionRelationIds);

    /**
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return 需求编码
     */
    Page<DemandInfo> gePageByStatusJobCateId(Integer currentPage, Integer pageSize, Long employerId, Integer status,
                                             Integer jobCateId);

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

    List<DemandInfo> findDemandInfoLikeNameOrCode(String str);


    Page<DemandInfo> getPageDemandInfo(List<Long> demandId,Integer currentPage,Integer pageSize,Integer demandStatus);
    /**
     * 查询我发布的全部需求
     * @param currentPage
     * @param pageSize
     * @param employerId
     * @return
     */
    Page<DemandInfo> getPageByEmployerId(Integer currentPage, Integer pageSize, Integer status, Long employerId);

    /**
     * 查询我申请的和平台推荐的需求
     * @param currentPage
     * @param pageSize
     * @param status
     * @param demandProductionRelationIds
     * @return
     */
    Page<DemandInfo> getPageByDemandStatus(Integer currentPage, Integer pageSize, Integer status, List<Long> demandProductionRelationIds);

    Integer getDemandCountByStatus(Long employerId, Integer status, List<Long> demandProductionRelationIds);

    Integer getDemandClosedCount(List<Long> demandId);

    Integer getOpenedDemandCount(List<Long> demandId);

    Page<DemandInfo> getDemandByKeyword(String keyword,List<Long> employerIds, Integer currentPage, Integer pageSize);
}
