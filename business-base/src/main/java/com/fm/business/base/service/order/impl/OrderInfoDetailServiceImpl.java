/**
 * @filename:OrderInfoDetailServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.order.impl;


import com.fm.business.base.dao.order.IOrderInfoDetailMapper;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
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
public class OrderInfoDetailServiceImpl extends AuditBaseService<IOrderInfoDetailMapper, OrderInfoDetail> implements IOrderInfoDetailService {

}