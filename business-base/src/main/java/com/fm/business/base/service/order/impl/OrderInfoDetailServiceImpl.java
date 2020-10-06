/**
 * @filename:OrderInfoDetailServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderInfoDetailMapper;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

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
    public List<OrderInfoDetail> getOrderDetailByOrderIds(List<Long> orderIds) {
        if (CollectionUtils.isEmpty(orderIds)) {
            return Collections.EMPTY_LIST;
        }
        return getBaseMapper().selectList(Wrappers.lambdaQuery(OrderInfoDetail.class).in(OrderInfoDetail::getOrderId,
                orderIds));
    }
}
