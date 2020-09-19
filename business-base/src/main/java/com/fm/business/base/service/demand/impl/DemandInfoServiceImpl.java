/**
 * @filename:DemandInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand.impl;

import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:(需求服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("demandInfoService")
public class DemandInfoServiceImpl extends AuditBaseService<IDemandInfoMapper, DemandInfo> implements IDemandInfoService {


}
