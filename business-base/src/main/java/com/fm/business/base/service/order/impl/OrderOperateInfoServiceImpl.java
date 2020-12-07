/**
 * @filename:OrderInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderOperateInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.AttachmentType;
import com.fm.business.base.enums.OrderOperateType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.order.IOrderOperateInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.enums.YesNoEnum;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @Override
    public void saveOperateInfo(Long orderId, Integer status, String description, List<AttachmentInfo> attachmentList) {
        OrderOperateInfo orderOperateInfo = new OrderOperateInfo();

        if (OrderStatus.TAKING_40.getCode().equals(status)) {
            OrderInfo orderInfo = iOrderInfoService.get(orderId);
            if(orderInfo.getFreelancerId().equals(Context.getCurrFreelancerId())){
                orderOperateInfo.setOperateType(OrderOperateType.RECEIVE.getCode());
                orderOperateInfo.setOperateUser(Context.getCurrFreelancerId());
                orderOperateInfo.setReceiveUser(Context.getCurrEmployerId());
            }else {
                orderOperateInfo.setOperateType(OrderOperateType.SUBMIT_PAYMENT_VOUCHER.getCode());
                orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
                orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
            }
        } else if (OrderStatus.CHECKING_60.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.SUBMIT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrFreelancerId());
            orderOperateInfo.setReceiveUser(Context.getCurrEmployerId());
        } else if (OrderStatus.CHECK_FAIL_61.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.SUBMIT_AGAIN.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        } else if (OrderStatus.CHECK_FAIL_70.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.UNACCEPT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        } else if (OrderStatus.FINISHED_80.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.ACCEPT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        } else if (OrderStatus.FINISHED_81.getCode().equals(status)) {
            orderOperateInfo.setOperateType(OrderOperateType.UNACCEPT.getCode());
            orderOperateInfo.setOperateUser(Context.getCurrEmployerId());
            orderOperateInfo.setReceiveUser(Context.getCurrFreelancerId());
        }else {
            // 非此三种操作类型，不记录
            return;
        }

        orderOperateInfo.setOrderId(orderId);
        orderOperateInfo.setDescription(description);
        this.save(orderOperateInfo);


        if (!CollectionUtils.isEmpty(attachmentList)) {
            for (AttachmentInfo attachmentInfo : attachmentList) {
                attachmentInfo.setBusinessCode(orderOperateInfo.getId().toString());
                attachmentInfo.setType(AttachmentType.PICTURE.getCode());
                attachmentInfo.setBusinessType(AttachmentBusinessType.ORDER_OPERATE.getCode());
            }
        }

        attachmentInfoService.save(attachmentList);
    }


    @Override
    protected void afterSave(OrderOperateInfo orderOperateInfo) {
        if(OrderOperateType.SUBMIT_PAYMENT_VOUCHER.getCode().equals(orderOperateInfo.getOperateType())){
            OrderInfo orderInfo = iOrderInfoService.get(orderOperateInfo.getOrderId());
            if(YesNoEnum.No.getIndex().equals(orderInfo.getIsUploadVoucher())){
                OrderInfo updateOrderInfo = new OrderInfo();
                updateOrderInfo.setIsUploadVoucher(YesNoEnum.Yes.getIndex());
                iOrderInfoService.update(updateOrderInfo);
            }
        }
    }

    @Override
    protected void afterDelete(OrderOperateInfo orderOperateInfo) {
        attachmentInfoService.deleteByBusinessCode(orderOperateInfo.getId().toString());
    }

    @Override
    public List<OrderOperateInfo> findByOrderId(Long orderId, Integer... orderOperateTypes) {

        List<OrderOperateInfo> orderOperateInfos = getBaseMapper().selectList(Wrappers.lambdaQuery(OrderOperateInfo.class)
                .eq(OrderOperateInfo::getOrderId,orderId)
                .in(orderOperateTypes != null,OrderOperateInfo::getOperateType,orderOperateTypes)
                .orderByDesc(OrderOperateInfo::getCreateTime));
        fillProductInfoRelation(orderOperateInfos);
        return orderOperateInfos;
    }

    /**
     * 补全数据
     *
     * @param orderOperateInfos
     */
    private void fillProductInfoRelation(Collection<OrderOperateInfo> orderOperateInfos) {

        Set<String> attachmentCodes = new HashSet<>();

        orderOperateInfos.forEach(orderOperateInfo -> {
            attachmentCodes.add(String.valueOf(orderOperateInfo.getId()));
        });

        Map<String, List<AttachmentInfo>> attachmentMap = attachmentInfoService.getByCodeAndType(attachmentCodes, AttachmentBusinessType.ORDER_OPERATE)
                .stream().collect(Collectors.toMap(AttachmentInfo::getBusinessCode, v -> {
                    List<AttachmentInfo> list = new ArrayList<>();
                    list.add(v);
                    return list;
                }, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }));

        orderOperateInfos.forEach(orderOperateInfo -> {

            if (attachmentMap.containsKey(orderOperateInfo.getId().toString())) {
                orderOperateInfo.setAttachmentInfos(attachmentMap.get(orderOperateInfo.getId().toString()));
            }

        });
    }
}
