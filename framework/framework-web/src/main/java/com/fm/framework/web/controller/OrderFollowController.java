/**
* @filename:OrderFollowController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.framework.web.controller;

import com.fm.framework.core.model.OrderFollow;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IOrderFollowService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.vo.OrderFollowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 订单流水API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/orderFollow")
public class OrderFollowController extends BaseController<OrderFollow, OrderFollowVO>{

    @Autowired
    @Qualifier("orderFollowService")
    private IOrderFollowService orderFollowService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody OrderFollowVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody OrderFollowVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<OrderFollowVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<OrderFollow> service() {
        return orderFollowService;
    }

    @Override
    protected OrderFollow convert(OrderFollowVO form) {
        OrderFollow model = new OrderFollow();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected OrderFollowVO convert(OrderFollow model) {
        OrderFollowVO form = new OrderFollowVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}