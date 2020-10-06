/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.business.base.enums.OrderOperateRoleType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.UserType;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.order.IOrderOperateInfoService;
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
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

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
@Api(value = "订单接口", tags={"订单操作相关接口"})
public class OrderApiController extends BaseController<OrderInfo, OrderInfoVO> {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IOrderFollowService orderFollowService;

    @Autowired
    private IOrderOperateInfoService orderOperateInfoService;

    @RequestMapping(value = "getOrderListByStakeholder",method = RequestMethod.GET)
    @ApiOperation(value="根据订单参与者ID获取订单（订单参与者：雇主/自由职业者）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer",paramType = "query")})
    public ApiResponse<Page<OrderInfoVO>> getOrderListByStakeholder(@RequestParam("currentPage") Integer currentPage
            , @RequestParam("pageSize") Integer pageSize, @RequestParam("orderType") Integer orderType) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();

        Page<OrderInfo> orderInfoPage = orderInfoService.queryOrderInfoByPage(currEmployerId, currFreelancerId, currentPage, pageSize,orderType);
        Page<OrderInfoVO> orderInfoVOPage = convert(orderInfoPage);

        fillStatusName(orderInfoVOPage.getData());
        fillUserType(orderInfoVOPage.getData(), currEmployerId, currFreelancerId);
        fillOrderDetailInfo(orderInfoVOPage.getData());

        return ApiResponse.ofSuccess(orderInfoVOPage);
    }

    private void fillOrderDetailInfo(List<OrderInfoVO> orderInfoVOS) {
        List<Long> orderIds = new ArrayList<>();
        for (OrderInfoVO orderInfoVO : orderInfoVOS) {
            orderIds.add(orderInfoVO.getId());
        }

        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("orderId");
        queryItem.setType(QueryType.in);
        queryItem.setValue(orderIds);
        queryItems.add(queryItem);
        List<OrderInfoDetail> orderInfoDetails = orderInfoDetailService.get(queryItems);
        Map<Long, OrderInfoDetail> detailsMap = new HashedMap();
        for (OrderInfoDetail orderInfoDetail : orderInfoDetails) {
            detailsMap.put(orderInfoDetail.getOrderId(), orderInfoDetail);
        }

        OrderInfoDetail detail;
        for (OrderInfoVO orderInfoVO : orderInfoVOS) {
            if (detailsMap.containsKey(orderInfoVO.getId())) {
                detail = detailsMap.get(orderInfoVO.getId());
                orderInfoVO.setSummarize(detail.getSummarize());
                orderInfoVO.setDescription(detail.getDescription());
            }
        }

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
            orderInfoVO.setStatusStep(OrderStatus.get(orderInfoVO.getStatus()).getStep());
        }

        fillOrderDetailInfo(orderInfoVO);

        // belong to
        if (Context.getCurrEmployerId().equals(orderInfoVO.getEmployerId())) {
            orderInfoVO.setOrderBelongType(OrderOperateRoleType.EMPLOYER.getCode());
        } else if (Context.getCurrFreelancerId().equals(orderInfoVO.getFreelancerId())) {
            orderInfoVO.setOrderBelongType(OrderOperateRoleType.FREELANCER.getCode());
        }

        return ApiResponse.ofSuccess(orderInfoVO);
    }

    private void fillOrderDetailInfo(OrderInfoVO orderInfoVO) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("orderId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(orderInfoVO.getId());
        queryItems.add(queryItem);

        OrderInfoDetail orderInfoDetail = orderInfoDetailService.getOne(queryItems);
        orderInfoVO.setSummarize(orderInfoDetail.getSummarize());
        orderInfoVO.setDescription(orderInfoDetail.getDescription());
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

        // 写操作表
        saveOperateInfo(orderInfoVO);

        return ApiResponse.ofSuccess(true);
    }

    private void saveOperateInfo(OrderInfoVO orderInfoVO) {
        orderOperateInfoService.saveOperateInfo(orderInfoVO.getId(), orderInfoVO.getStatus(), orderInfoVO.getDescription(), orderInfoVO.getAttachmentList());
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
        orderInfoVO.setJobCateName(bdJobCateService.getFullTreePathById(orderInfoVO.getJobCateId()));

        // 写流水
        saveFollow(orderInfoVO);
    }

    private OrderInfoVO fillUserInfo(OrderInfo orderInfo) {
        // get userInfo
        FreelancerInfo freelancerInfo = freelancerInfoService.get(orderInfo.getFreelancerId());
        EmployerInfo employerInfo = employerInfoService.get(orderInfo.getEmployerId());

        // fill userInfo
        OrderInfoVO orderInfoVO = super.convert(orderInfo);
        if (freelancerInfo != null) {
            orderInfoVO.setFreelancerName(freelancerInfo.getName());
        }

        if (employerInfo != null) {
            orderInfoVO.setEmployerName(employerInfo.getName());
        }

        return orderInfoVO;
    }

    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }
}
