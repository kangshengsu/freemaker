/**
 * @filename:ProductionReviewInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.mapper.IProductionReviewInfoMapper;
import com.fm.business.base.model.ProductionReviewInfo;
import com.fm.business.base.service.IProductionReviewInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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