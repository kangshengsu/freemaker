package com.fm.business.base.service.order;

import com.fm.business.base.model.order.OrderAmount;
import com.fm.framework.core.service.Service;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 15:23
 */
public interface IOrderAmountService extends Service<OrderAmount> {
    OrderAmount getByOrderId(Long orderId);
}
