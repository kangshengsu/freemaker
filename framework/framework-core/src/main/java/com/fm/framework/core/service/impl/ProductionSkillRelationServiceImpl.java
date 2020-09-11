/**
 * @filename:ProductionSkillRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.ProductionSkillRelation;
import com.fm.framework.core.mapper.IProductionSkillRelationMapper;
import com.fm.framework.core.service.IProductionSkillRelationService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(作品技能关系服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("productionSkillRelationService")
public class ProductionSkillRelationServiceImpl extends BaseService<IProductionSkillRelationMapper, ProductionSkillRelation> implements IProductionSkillRelationService  {

  @Autowired
  private IProductionSkillRelationMapper productionSkillRelationMapper;
}