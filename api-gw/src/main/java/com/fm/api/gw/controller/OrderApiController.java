/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.UserType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/v1/orderApi")
@Api(value = "订单接口", tags={"作品操作相关接口"})
public class OrderApiController extends BaseController<OrderInfo, OrderInfoVO> {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IOrderFollowService orderFollowService;

    @RequestMapping(value = "getOrderListByStakeholder",method = RequestMethod.GET)
    @ApiOperation(value="根据订单参与者ID获取订单（订单参与者：雇主/自由职业者）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer",paramType = "query")})
    public ApiResponse<Page<OrderInfoVO>> getOrderListByStakeholder(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();

        Page<OrderInfo> orderInfoPage = orderInfoService.queryOrderInfoByPage(currEmployerId, currFreelancerId, currentPage, pageSize);
        Page<OrderInfoVO> orderInfoVOPage = convert(orderInfoPage);

        fillStatusName(orderInfoVOPage.getData());
        fillUserType(orderInfoVOPage.getData(), currEmployerId, currFreelancerId);

        return ApiResponse.ofSuccess(orderInfoVOPage);
    }

    private void fillUserType(List<OrderInfoVO> data, Long currEmployerId, Long currFreelancerId) {
        for (OrderInfoVO datum : data) {
            if (currEmployerId.equals(datum.getEmployerId())) {
                datum.setUserType(UserType.EMPLOYER.getCode());
            } else if (currFreelancerId.equals(datum.getFreelancerId())) {
                datum.setUserType(UserType.FREELANCER.getCode());
            }
        }
    }


    private void fillStatusName(List<OrderInfoVO> data) {
        for (OrderInfoVO orderInfoVO : data) {
            orderInfoVO.setStatusName(OrderStatus.get(orderInfoVO.getStatus()).getName());
        }
    }

    @ApiOperation(value="根据主键获取订单")
    @ApiImplicitParam(paramType="query", name = "code", value = "订单主键", required = true, dataType = "String")
    @RequestMapping(value = "getOrderInfoById",method = RequestMethod.GET)
    public ApiResponse<OrderInfoVO> getOrderInfoById(Long id) {
        // search order info
        OrderInfo orderInfo = orderInfoService.get(id);
        OrderInfoVO orderInfoVO = null;
        if (orderInfo != null) {
            orderInfoVO = fillUserInfo(orderInfo);
            fillJobInfo(orderInfoVO);
            orderInfoVO.setStatusName(OrderStatus.get(orderInfoVO.getStatus()).getName());
        }

        return ApiResponse.ofSuccess(orderInfoVO);
    }

    @ApiOperation(value="下单")
    @ApiImplicitParam(paramType="query", name = "code", value = "订单信息", required = true, dataType = "String")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody OrderInfoVO orderInfoVO) {
        // search order info
        orderInfoService.save(this.convert(orderInfoVO));

        // 写流水
        saveFollow(orderInfoVO);

        return ApiResponse.ofSuccess(true);
    }

    @ApiOperation(value="订单状态变更")
    @ApiImplicitParam(paramType="body", name = "orderInfoVO", value = "订单操作信息", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderStatus",method = RequestMethod.PUT)
    public ApiResponse<Boolean> updateOrderStatus(@RequestBody OrderInfoVO orderInfoVO) {
        this.update(orderInfoVO);

        // 写流水
        saveFollow(orderInfoVO);
        return ApiResponse.ofSuccess(true);
    }

    private void saveFollow(OrderInfoVO orderInfoVO) {
        // 写流水
        OrderFollow orderFollow = new OrderFollow();
        orderFollow.setOrderId(orderInfoVO.getId());
        orderFollow.setOperateType(orderInfoVO.getStatus());
        orderFollow.setMemo(orderInfoVO.getMemo());
        orderFollowService.save(orderFollow);
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

        // 写流水
        saveFollow(orderInfoVO);
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
        if (userMap.containsKey(orderInfoVO.getFreelancerId())) {
            orderInfoVO.setFreelancerName(userMap.get(orderInfoVO.getFreelancerId()).getName());
        }

        return orderInfoVO;
    }

    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }
}
