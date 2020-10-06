/**
 * @filename:OrderFollowServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.order.impl;


import com.fm.business.base.dao.order.IOrderFollowMapper;
import com.fm.business.base.enums.OrderOperateRoleType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
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
public class OrderFollowServiceImpl extends AuditBaseService<IOrderFollowMapper, OrderFollow> implements IOrderFollowService {

    @Override
    public void saveOperateFollow(OrderInfo orderInfo) {
        OrderFollow orderFollow = new OrderFollow();
        orderFollow.setOrderId(orderInfo.getId());
        orderFollow.setOperateType(orderInfo.getStatus());

        Integer operateType = OrderStatus.get(orderInfo.getStatus()).getOperateType();
        if (OrderOperateRoleType.EMPLOYER.getCode().equals(operateType)) {
            orderFollow.setOperateUser(Context.getCurrEmployerId());
        } if (OrderOperateRoleType.FREELANCER.getCode().equals(operateType)) {
            orderFollow.setOperateUser(Context.getCurrFreelancerId());
        }

        this.save(orderFollow);
    }
}