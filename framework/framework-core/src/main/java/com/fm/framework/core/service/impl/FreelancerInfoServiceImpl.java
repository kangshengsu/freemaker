/**
 * @filename:FreelancerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.FreelancerInfo;
import com.fm.framework.core.mapper.IFreelancerInfoMapper;
import com.fm.framework.core.service.IFreelancerInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(自由职业者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("freelancerInfoService")
public class FreelancerInfoServiceImpl extends BaseService<IFreelancerInfoMapper, FreelancerInfo> implements IFreelancerInfoService  {

  @Autowired
  private IFreelancerInfoMapper freelancerInfoMapper;
}