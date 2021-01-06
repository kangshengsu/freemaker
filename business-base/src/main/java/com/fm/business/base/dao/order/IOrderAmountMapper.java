package com.fm.business.base.dao.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.business.base.model.order.OrderAmount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 15:25
 */
@Mapper
public interface IOrderAmountMapper extends BaseMapper<OrderAmount> {
}
