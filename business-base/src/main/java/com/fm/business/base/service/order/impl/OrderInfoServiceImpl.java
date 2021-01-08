/**
 * @filename:OrderInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderInfoMapper;
import com.fm.business.base.enums.MiniAppOrderTypeEnum;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.order.IOrderAmountService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description:(订单信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("orderInfoService")
public class OrderInfoServiceImpl extends AuditBaseService<IOrderInfoMapper, OrderInfo> implements IOrderInfoService {
    @Autowired
    private IOrderFollowService orderFollowService;

    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;

    @Autowired
    private IOrderAmountService orderAmountService;

    @Override
    protected void beforeSave(OrderInfo model) {
        super.beforeSave(model);
        model.setCode(CodeUtil.generateNewCode2yyMMddHH());
    }

    @Override
    public List<OrderInfo> queryFinishedOrderByFreelancer(Long freelancerId) {
        LambdaQueryWrapper<OrderInfo> wrapper = Wrappers.<OrderInfo>lambdaQuery()
                .eq(OrderInfo::getFreelancerId, freelancerId)
                .in(OrderInfo::getStatus, new Integer[]{OrderStatus.FINISHED_80.getCode(), OrderStatus.EVALUATED_90.getCode()})
                .orderByDesc(OrderInfo::getCreateTime);
        return getBaseMapper().selectList(wrapper);
    }

    @Override
    public int getOrderCountByDemandId(Long demandId) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = this.getQueryWrapper().lambda().eq(OrderInfo::getDemandId, demandId);
        return getBaseMapper().selectCount(queryWrapper);
    }

    @Override
    public Page<OrderInfo> queryOrderInfoByPage(Long employerId, Long freelancerId, long currPage, long pageSize,Integer orderType, Integer status) {
        LambdaQueryWrapper<OrderInfo> wrapper = Wrappers.<OrderInfo>lambdaQuery()
                .eq(status > 0, OrderInfo::getStatus, status);

        log.info("queryOrderInfoByPage employerId: {}, freelancerId: {}, status: {}, orderType: {}", employerId, freelancerId, status, orderType);

        if(Objects.isNull(employerId)) {
            employerId = -1L;
        }

        if(Objects.isNull(freelancerId)) {
            freelancerId = -1L;
        }

        final Long _employerId = employerId;
        final Long _freelancerId = freelancerId;

        MiniAppOrderTypeEnum orderTypeEnum = MiniAppOrderTypeEnum.resolve(orderType);
        switch (orderTypeEnum) {
            case RECEIVED:
                wrapper.eq(OrderInfo::getFreelancerId, _freelancerId);
                break;
            case INITIATE:
                wrapper.eq(OrderInfo::getEmployerId, _employerId);
                break;
            case ALL:
                wrapper.and(w-> w.eq(OrderInfo::getFreelancerId, _freelancerId).or().eq(OrderInfo::getEmployerId, _employerId));

        }
        wrapper.orderByDesc(OrderInfo::getCreateTime);
        return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currPage, pageSize), wrapper));
    }

    @Override
    protected void afterSave(OrderInfo model) {
        super.afterSave(model);
        orderFollowService.saveOperateFollow(model);
        model.getOrderInfoDetail().setOrderId(model.getId());
        orderInfoDetailService.save(model.getOrderInfoDetail());
        model.getOrderAmount().setOrderId(model.getId());
        orderAmountService.save(model.getOrderAmount());
    }

    @Override
    protected void afterUpdate(OrderInfo model) {
        super.afterUpdate(model);
        model.getOrderInfoDetail().setOrderId(model.getId());
        orderInfoDetailService.update(model.getOrderInfoDetail());
    }
}
