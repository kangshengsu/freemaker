/**
 * @filename:ProductionSkillRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production.impl;

import com.fm.business.base.dao.production.IProductionSkillRelationMapper;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.production.IProductionSkillRelationService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
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
public class ProductionSkillRelationServiceImpl extends AuditBaseService<IProductionSkillRelationMapper, ProductionSkillRelation> implements IProductionSkillRelationService {

}