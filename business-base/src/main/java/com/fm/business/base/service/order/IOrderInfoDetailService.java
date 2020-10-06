/**
 * @filename:OrderInfoDetailService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order;

import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(订单详情服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IOrderInfoDetailService extends Service<OrderInfoDetail> {
    /**
     * 根据订单主键获取订单详情
     * @param orderIds 订单主键
     * @return
     */
    List<OrderInfoDetail> getOrderDetailByOrderIds(List<Long> orderIds);


}
