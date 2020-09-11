/**
 * @filename:DemandInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.DemandInfo;
import com.fm.framework.core.mapper.IDemandInfoMapper;
import com.fm.framework.core.service.IDemandInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DemandInfoServiceImpl extends BaseService<IDemandInfoMapper, DemandInfo> implements IDemandInfoService  {

  @Autowired
  private IDemandInfoMapper demandInfoMapper;
}