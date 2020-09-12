/**
 * @filename:DemandInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;

import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.model.DemandInfo;
import com.fm.business.base.service.IDemandInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
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
public class DemandInfoServiceImpl extends BaseService<IDemandInfoMapper, DemandInfo> implements IDemandInfoService {


}