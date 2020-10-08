/**
 * @filename:OrderInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.order.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.order.IOrderInfoMapper;
import com.fm.business.base.enums.MiniAppOrderTypeEnum;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    protected void beforeSave(OrderInfo model) {
        super.beforeSave(model);
        model.setCode(CodeUtil.generateNewCode());
    }

    @Override
    public List<OrderInfo> queryFinishedOrderByFreelancer(Long freelancerId) {
        LambdaQueryWrapper<OrderInfo> wrapper = Wrappers.<OrderInfo>lambdaQuery()
                .eq(OrderInfo::getFreelancerId, freelancerId)
                .in(OrderInfo::getStatus, new Integer[]{OrderStatus.FINISHED_70.getCode(), OrderStatus.EVALUATED_80.getCode()});
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

        MiniAppOrderTypeEnum orderTypeEnum = MiniAppOrderTypeEnum.resolve(orderType);
        switch (orderTypeEnum) {
            case RECEIVED:
                wrapper.eq(OrderInfo::getFreelancerId, freelancerId);
                break;
            case INITIATE:
                wrapper.eq(OrderInfo::getEmployerId, employerId);
                break;
            case ALL:
        }

        return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currPage, pageSize), wrapper));
    }
}
