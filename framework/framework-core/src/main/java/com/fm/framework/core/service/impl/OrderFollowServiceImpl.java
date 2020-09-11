/**
 * @filename:OrderFollowServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.OrderFollow;
import com.fm.framework.core.mapper.IOrderFollowMapper;
import com.fm.framework.core.service.IOrderFollowService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(订单流水服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("orderFollowService")
public class OrderFollowServiceImpl extends BaseService<IOrderFollowMapper, OrderFollow> implements IOrderFollowService  {

  @Autowired
  private IOrderFollowMapper orderFollowMapper;
}