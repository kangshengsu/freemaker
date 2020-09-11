/**
 * @filename:OrderInfoDetailServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.OrderInfoDetail;
import com.fm.framework.core.mapper.IOrderInfoDetailMapper;
import com.fm.framework.core.service.IOrderInfoDetailService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(订单详情服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("orderInfoDetailService")
public class OrderInfoDetailServiceImpl extends BaseService<IOrderInfoDetailMapper, OrderInfoDetail> implements IOrderInfoDetailService  {

  @Autowired
  private IOrderInfoDetailMapper orderInfoDetailMapper;
}