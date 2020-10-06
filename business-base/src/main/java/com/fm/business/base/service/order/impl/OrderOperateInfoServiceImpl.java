/**
 * @filename:OrderInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;

import com.fm.business.base.dao.order.IOrderOperateInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.OrderOperateType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.order.IOrderOperateInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:(订单信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("orderOperateInfoService")
public class OrderOperateInfoServiceImpl extends AuditBaseService<IOrderOperateInfoMapper, OrderOperateInfo> implements IOrderOperateInfoService {
    @Autowired
    private IAttachmentInfoService attachmentInfoService;

    @Override
    public void saveOperateInfo(Long orderId, Integer status, String description, List<String> attachmentList) {
        OrderOperateInfo orderOperateInfo = new OrderOperateInfo();
        if (OrderStatus.CHECKING_50.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.SUBMIT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrFreelancerId());
            orderOperateInfo.setReceiveUser(Context.getCurrEmployerId());
        } else if (OrderStatus.CHECK_FAIL_60.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.UNACCEPT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        } else if (OrderStatus.FINISHED_70.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.ACCEPT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        } else {
            // 非此三种操作类型，不记录
            return;
        }

        orderOperateInfo.setOrderId(orderId);
        orderOperateInfo.setDescription(description);
        this.save(orderOperateInfo);

        List<AttachmentInfo> attachmentInfos = new ArrayList<>();
        AttachmentInfo attachmentInfo;
        for (String attachment : attachmentList) {
            attachmentInfo = new AttachmentInfo();
            attachmentInfo.setBusinessCode(orderOperateInfo.getId().toString());
            attachmentInfo.setType(AttachmentBusinessType.ORDER_OPERATE.getCode());
            attachmentInfo.setPath(attachment);
            attachmentInfos.add(attachmentInfo);
        }

        attachmentInfoService.save(attachmentInfos);
    }
}