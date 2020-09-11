/**
 * @filename:OrderInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.OrderInfo;
import com.fm.framework.core.mapper.IOrderInfoMapper;
import com.fm.framework.core.service.IOrderInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(订单信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("orderInfoService")
public class OrderInfoServiceImpl extends BaseService<IOrderInfoMapper, OrderInfo> implements IOrderInfoService  {

  @Autowired
  private IOrderInfoMapper orderInfoMapper;
}