/**
* @filename:OrderInfoDetailController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.order;

import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.order.OrderInfoDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 订单详情API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/order/orderInfoDetail")
public class OrderInfoDetailController extends BaseController<OrderInfoDetail, OrderInfoDetailVO> {

    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody OrderInfoDetailVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody OrderInfoDetailVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<OrderInfoDetailVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<OrderInfoDetail> service() {
        return orderInfoDetailService;
    }

    @Override
    protected OrderInfoDetail convert(OrderInfoDetailVO form) {
        OrderInfoDetail model = new OrderInfoDetail();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected OrderInfoDetailVO convert(OrderInfoDetail model) {
        OrderInfoDetailVO form = new OrderInfoDetailVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}