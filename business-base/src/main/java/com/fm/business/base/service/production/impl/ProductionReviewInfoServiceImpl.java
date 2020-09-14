/**
 * @filename:ProductionReviewInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production.impl;


import com.fm.business.base.dao.production.IProductionReviewInfoMapper;
import com.fm.business.base.model.production.ProductionReviewInfo;
import com.fm.business.base.service.production.IProductionReviewInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(作品审核服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("productionReviewInfoService")
public class ProductionReviewInfoServiceImpl extends BaseService<IProductionReviewInfoMapper, ProductionReviewInfo> implements IProductionReviewInfoService {

}