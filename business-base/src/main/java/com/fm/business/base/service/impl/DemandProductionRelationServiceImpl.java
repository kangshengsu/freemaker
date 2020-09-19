/**
 * @filename:DemandProductionRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;

import com.fm.business.base.dao.IDemandProductionRelationMapper;
import com.fm.business.base.model.DemandProductionRelation;
import com.fm.business.base.service.IDemandProductionRelationService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
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
public class DemandProductionRelationServiceImpl extends AuditBaseService<IDemandProductionRelationMapper, DemandProductionRelation> implements IDemandProductionRelationService {


}