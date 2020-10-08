/**
 * @filename:ProductionReviewInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production;

import com.fm.business.base.enums.ProductionReviewStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionReviewInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(作品审核服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IProductionReviewInfoService extends Service<ProductionReviewInfo> {

    /**
     * 作品审核服务 只允许操作【审核中】【审核未通过】的作品
     *
     * 更新作品状态
     * 保存审核记录
     *
     * @param productionReviewInfo
     * @param productionReviewStatus
     * @return
     */
    boolean review(ProductionReviewInfo productionReviewInfo, ProductionReviewStatus productionReviewStatus);


    /**
     * 获取作品审核意见
     * @param productionId
     * @param statuses 为空时可获取全部状态数据
     * @return
     */
    List<ProductionReviewInfo> getByProductionId(Long productionId, ProductionReviewStatus... statuses);

}