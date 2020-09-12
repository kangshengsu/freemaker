/**
 * @filename:ProductionInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.IProductionInfoMapper;
import com.fm.business.base.model.ProductionInfo;
import com.fm.business.base.service.IProductionInfoService;
import com.fm.framework.core.service.BaseService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(作品服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("productionInfoService")
public class ProductionInfoServiceImpl extends BaseService<IProductionInfoMapper, ProductionInfo> implements IProductionInfoService {


}