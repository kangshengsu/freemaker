/**
 * @filename:OrderFollowServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.IOrderFollowMapper;
import com.fm.business.base.model.OrderFollow;
import com.fm.business.base.service.IOrderFollowService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(订单流水服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("orderFollowService")
public class OrderFollowServiceImpl extends BaseService<IOrderFollowMapper, OrderFollow> implements IOrderFollowService {

}