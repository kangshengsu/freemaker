/**
 * @filename:ProductionInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.ProductionInfo;
import com.fm.framework.core.mapper.IProductionInfoMapper;
import com.fm.framework.core.service.IProductionInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductionInfoServiceImpl extends BaseService<IProductionInfoMapper, ProductionInfo> implements IProductionInfoService  {

  @Autowired
  private IProductionInfoMapper productionInfoMapper;
}