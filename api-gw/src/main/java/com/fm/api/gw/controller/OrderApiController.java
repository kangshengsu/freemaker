/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.query.OrderInfoQueryRequest;
import com.fm.api.gw.vo.JobCateVO;
import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* <p>说明： 岗位API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/miniApp/orderApi")
@Api(value = "订单接口")
public class OrderApiController extends BaseController<OrderInfo, OrderInfoVO> {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IOrderFollowService orderFollowService;

    @RequestMapping(value = "getOrderInfoByEmployerId",method = RequestMethod.GET)
    @ApiOperation(value="根据发布者ID获取订单")
    @ApiImplicitParam(paramType="form", name = "queryRequest", value = "查询条件", required = true, dataType = "OrderInfoQueryRequest")
    public ApiResponse<Page<OrderInfo>> getOrderInfoByEmployerId(OrderInfoQueryRequest queryRequest) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("employerId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(queryRequest.getEmployerId());
        queryItems.add(queryItem);

        Page<OrderInfo> orderInfoPage = orderInfoService.list(queryItems, queryRequest.getCurrPage(), queryRequest.getPageSize());
        return ApiResponse.ofSuccess(orderInfoPage);
    }

    @ApiOperation(value="根据编码获取订单")
    @ApiImplicitParam(name = "code", value = "订单编码", required = true, dataType = "")
    @RequestMapping(value = "getOrderInfoByCode",method = RequestMethod.GET)
    public ApiResponse<OrderInfo> getOrderInfoByCode(@RequestParam("code") String code) {
        // create queryItemSwagger
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("code");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(code);
        queryItems.add(queryItem);

        // search order info
        OrderInfo orderInfo = orderInfoService.getOne(queryItems);
        if (orderInfo != null) {
            OrderInfoVO orderInfoVO = fillUserInfo(orderInfo);

            fillJobInfo(orderInfoVO);
        }

        return ApiResponse.ofSuccess(orderInfo);
    }

    @ApiOperation(value="订单状态变更")
    @ApiImplicitParam(paramType="body", name = "orderInfoVO", value = "订单操作信息", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderStatus",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateOrderStatus(OrderInfoVO orderInfoVO) {
        OrderInfo orderInfo = this.convert(orderInfoVO);
        orderInfoService.update(orderInfo);

        // 写流水
        OrderFollow orderFollow = new OrderFollow();
        orderFollow.setOrderId(orderInfo.getId());
        orderFollow.setOperateType(orderInfo.getStatus());
        orderFollow.setMemo(orderInfoVO.getMemo());
        orderFollowService.save(orderFollow);

        return ApiResponse.ofSuccess(true);
    }

    @ApiOperation(value="订单信息变更")
    @ApiImplicitParam(paramType="body", name = "orderInfoVO", value = "订单信息变更", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderInfo",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateOrderInfo(OrderInfoVO orderInfoVO) {
        return this.update(orderInfoVO);
    }

    private void fillJobInfo(OrderInfoVO orderInfoVO) {
        BdJobCate bdJobCate = bdJobCateService.get(orderInfoVO.getJobCateId());
        orderInfoVO.setJobCateName(bdJobCate.getCateName());
    }

    private OrderInfoVO fillUserInfo(OrderInfo orderInfo) {
        // get userInfo
        List<Long> userIds = new ArrayList<>();
        userIds.add(orderInfo.getEmployerId());
        userIds.add(orderInfo.getFreelancerId());
        List<SysUser> sysUsers = sysUserService.getByIds(userIds);
        Map<Long, SysUser> userMap = new HashMap<>();
        for (SysUser sysUser : sysUsers) {
            userMap.put(sysUser.getId(), sysUser);
        }

        // fill userInfo
        OrderInfoVO orderInfoVO = super.convert(orderInfo);
        if (userMap.containsKey(orderInfoVO.getFreelancerId())) {
            orderInfoVO.setFreelancerName(userMap.get(orderInfoVO.getFreelancerId()).getName());
        }

        if (userMap.containsKey(orderInfoVO.getEmployerId())) {
            orderInfoVO.setEmployerName(userMap.get(orderInfoVO.getEmployerId()).getName());
        }

        return orderInfoVO;
    }

    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }
}
