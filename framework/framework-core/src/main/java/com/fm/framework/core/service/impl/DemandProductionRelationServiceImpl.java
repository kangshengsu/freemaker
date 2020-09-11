/**
 * @filename:DemandProductionRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.DemandProductionRelation;
import com.fm.framework.core.mapper.IDemandProductionRelationMapper;
import com.fm.framework.core.service.IDemandProductionRelationService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(需求作品关系服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("demandProductionRelationService")
public class DemandProductionRelationServiceImpl extends BaseService<IDemandProductionRelationMapper, DemandProductionRelation> implements IDemandProductionRelationService  {

  @Autowired
  private IDemandProductionRelationMapper demandProductionRelationMapper;
}