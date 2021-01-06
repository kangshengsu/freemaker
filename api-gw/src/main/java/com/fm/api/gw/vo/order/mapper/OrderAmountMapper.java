package com.fm.api.gw.vo.order.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.order.OrderAmountVO;
import com.fm.business.base.model.order.OrderAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 17:12
 */
@Mapper(componentModel = "spring")
public abstract class OrderAmountMapper extends CommonMapper {

    @Mappings({
            @Mapping(target = "freelancerServiceCharge", source = "freelancerServiceCharge", qualifiedByName = "addPercent"),
            @Mapping(target = "employerServiceCharge",source = "employerServiceCharge",qualifiedByName = "addPercent")

    })
    public abstract OrderAmountVO toOrderAmountVO(OrderAmount orderAmount);
}
