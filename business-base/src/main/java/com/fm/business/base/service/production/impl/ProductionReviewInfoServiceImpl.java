/**
 * @filename:ProductionReviewInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production.impl;


import com.fm.business.base.dao.production.IProductionReviewInfoMapper;
import com.fm.business.base.enums.ProductionReviewStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionReviewInfo;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.production.IProductionReviewInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Description:(作品审核服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("productionReviewInfoService")
public class ProductionReviewInfoServiceImpl extends AuditBaseService<IProductionReviewInfoMapper, ProductionReviewInfo> implements IProductionReviewInfoService {

    @Autowired
    private IProductionInfoService productionInfoService;

    /**
     * 作品审核服务 只允许操作【审核中】的作品
     *
     * 更新作品状态
     * 保存审核记录
     *
     * @param productionReviewInfo
     * @param productionReviewStatus
     * @return
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean review(ProductionReviewInfo productionReviewInfo, ProductionReviewStatus productionReviewStatus) {
        //检查当前作品状态 只允许审核审核中的作品
        ProductionInfo productionInfo = productionInfoService.get(productionReviewInfo.getProductionId());
        if(productionInfo == null){
            throw new BusinessException("作品不存在！");
        }else if(!ProductionStatus.REVIEW.getCode().equals(productionInfo.getStatus())
                &&!ProductionStatus.REVIEW_NOT_PASS.getCode().equals(productionInfo.getStatus())){
            throw new BusinessException("不允许审核非【审核中】或【审核未通过】状态的作品！");
        }
        //设置审核人
        productionReviewInfo.setReviewerId(Context.getCurrUser());
        //设置审核状态
        productionReviewInfo.setStatus(productionReviewStatus.getCode());
        //保存审核结果
        if(!save(productionReviewInfo)){
            //保存失败
            return false;
        }
        //更新作品状态
        ProductionInfo updateProductionInfo = new ProductionInfo();
        updateProductionInfo.setId(productionReviewInfo.getProductionId());
        if(ProductionReviewStatus.REVIEW_PASS.equals(productionReviewStatus)){
            updateProductionInfo.setStatus(ProductionStatus.RELEASE.getCode());
        }else if(ProductionReviewStatus.REVIEW_NOT_PASS.equals(productionReviewStatus)){
            updateProductionInfo.setStatus(ProductionStatus.REVIEW_NOT_PASS.getCode());
        }
        if(!productionInfoService.updateStatus(updateProductionInfo)){
            //更新作品失败 抛出异常回滚审核记录数据
            throw new BusinessException("审核作品时更新作品状态失败！");
        }


        return true;
    }
}