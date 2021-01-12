/**
 * @filename:OrderInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order;

import com.fm.business.base.model.order.OrderInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(订单信息服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IOrderInfoService extends Service<OrderInfo> {

    List<OrderInfo> queryFinishedOrderByFreelancer(Long freelancerId);

    int getOrderCountByDemandId(Long demandId);

    Page<OrderInfo> queryOrderInfoByPage(Long employerId, Long freelancerId, long currPage, long pageSize,Integer orderType, Integer status);

    Long getOrderIdByCode(String code);
}
