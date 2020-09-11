/**
 * @filename:BdJobCateServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.BdJobCate;
import com.fm.framework.core.mapper.IBdJobCateMapper;
import com.fm.framework.core.service.IBdJobCateService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(岗位服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobCateService")
public class BdJobCateServiceImpl extends BaseService<IBdJobCateMapper, BdJobCate> implements IBdJobCateService  {

  @Autowired
  private IBdJobCateMapper bdJobCateMapper;
}