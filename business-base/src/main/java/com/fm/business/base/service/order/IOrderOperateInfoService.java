/**
 * @filename:OrderInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(订单操作服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IOrderOperateInfoService extends Service<OrderOperateInfo> {

    void saveOperateInfo(Long orderId, Integer status, String description, List<AttachmentInfo> attachmentList);

    /**
     * 后台修改订单状态
     * @param orderId
     * @param status
     * @param description
     * @param attachmentList
     */
    void saveOperateInfoBack(Long employerId, Long freelancerId, Long orderId, Integer status, String description, List<AttachmentInfo> attachmentList);

    List<OrderOperateInfo> findByOrderId(Long orderId, Integer... orderOperateTypes);

    List<OrderOperateInfo> findByOrderIds(List<Long> orderIds, Integer... orderOperateTypes);
}
