package com.fm.business.base.service.order.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderAmountMapper;
import com.fm.business.base.model.order.OrderAmount;
import com.fm.business.base.service.order.IOrderAmountService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 15:24
 */
@Service
public class
OrderAmountServiceImpl extends AuditBaseService<IOrderAmountMapper, OrderAmount> implements IOrderAmountService {
    @Override
    public OrderAmount getByOrderId(Long orderId) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(OrderAmount.class).eq(OrderAmount::getOrderId,orderId));
    }
}
