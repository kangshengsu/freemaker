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
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.service.AuditBaseService;
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
    public List<OrderInfo> queryFinishedOrderByFreelancer(Long freelancerId) {
        LambdaQueryWrapper<OrderInfo> wrapper = Wrappers.<OrderInfo>lambdaQuery()
                .eq(OrderInfo::getFreelancerId, freelancerId)
                .in(OrderInfo::getStatus, new Integer[]{OrderStatus.FINISHED_70.getCode(), OrderStatus.EVALUATED_80.getCode()});
        return getBaseMapper().selectList(wrapper);
    }

    @Override
    public int getOrderCountByDemandId(Long demandId) {
        QueryWrapper<OrderInfo> queryWrapper = this.getQueryWrapper().eq("demandId", demandId);
        return getBaseMapper().selectCount(queryWrapper);
    }
}
