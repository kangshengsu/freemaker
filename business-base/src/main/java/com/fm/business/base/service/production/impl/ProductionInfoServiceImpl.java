/**
 * @filename:ProductionInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production.impl;


import com.fm.business.base.dao.production.IProductionInfoMapper;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.service.AuditBaseService;
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
public class ProductionInfoServiceImpl extends AuditBaseService<IProductionInfoMapper, ProductionInfo> implements IProductionInfoService {


}