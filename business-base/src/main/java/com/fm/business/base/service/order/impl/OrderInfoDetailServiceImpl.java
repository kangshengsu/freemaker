/**
 * @filename:OrderInfoDetailServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderInfoDetailMapper;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description:(订单详情服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("orderInfoDetailService")
public class OrderInfoDetailServiceImpl extends AuditBaseService<IOrderInfoDetailMapper, OrderInfoDetail> implements IOrderInfoDetailService {


    @Override
    public List<OrderInfoDetail> getOrderDetailByOrderIds(Collection<Long> orderIds) {
        if (CollectionUtils.isEmpty(orderIds)) {
            return Collections.EMPTY_LIST;
        }
        return getBaseMapper().selectList(Wrappers.lambdaQuery(OrderInfoDetail.class).in(OrderInfoDetail::getOrderId,
                orderIds));
    }

    @Override
    public OrderInfoDetail getOrderInfoDetailByOrderId(Long orderId) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(OrderInfoDetail.class).eq(OrderInfoDetail::getOrderId,orderId));
    }
}
