/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.business.base.dao.freelancer.IFreelancerInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.OrderOperateRoleType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.IAttachmentInfoService;
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
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @Autowired
    private IFreelancerInfoMapper freelancerInfoMapper;

    @RequestMapping(value = "getOrderListByStakeholder",method = RequestMethod.GET)
    @ApiOperation(value="根据订单参与者ID获取订单（订单参与者：雇主/自由职业者）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer",paramType = "query")})
    public ApiResponse<Page<OrderInfoVO>> getOrderListByStakeholder(
            @RequestParam("currentPage") Integer currentPage
            , @RequestParam("pageSize") Integer pageSize
            , @RequestParam("orderType") Integer orderType
            , @RequestParam("status") Integer status) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();

        Page<OrderInfo> orderInfoPage = orderInfoService.queryOrderInfoByPage(currEmployerId, currFreelancerId, currentPage, pageSize,orderType, status);
        Page<OrderInfoVO> orderInfoVOPage = convert(orderInfoPage);

        fillStatusName(orderInfoVOPage.getData());
        fillJobInfos(orderInfoVOPage.getData());
        fillBelongType(orderInfoVOPage.getData(), currEmployerId, currFreelancerId);
        if (orderInfoVOPage.getData() != null && orderInfoVOPage.getData().size() > 0) {
            fillOrderDetailInfo(orderInfoVOPage.getData());
        }

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
        Map<Long, OrderInfoDetail> detailsMap = new HashMap();
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

    private void fillBelongType(List<OrderInfoVO> data, Long currEmployerId, Long currFreelancerId) {
        for (OrderInfoVO datum : data) {
            if (currEmployerId.equals(datum.getEmployerId())) {
                datum.setOrderBelongType(OrderOperateRoleType.EMPLOYER.getCode());
            } else if (currFreelancerId.equals(datum.getFreelancerId())) {
                datum.setOrderBelongType(OrderOperateRoleType.FREELANCER.getCode());
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

        orderInfoVO.setCanChargeback(isHour48Ago(orderInfoVO.getId()));

        return ApiResponse.ofSuccess(orderInfoVO);
    }

    private boolean isHour48Ago(Long orderId) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("orderId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(orderId);
        queryItems.add(queryItem);

        queryItem = new QueryItem();
        queryItem.setQueryField("operateType");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(OrderStatus.TAKING_40.getCode());
        queryItems.add(queryItem);

        List<OrderFollow> ororderFollows = orderFollowService.get(queryItems);

        Date createTime = null;
        if (ororderFollows != null && ororderFollows.size() > 0) {
            createTime = ororderFollows.get(0).getCreateTime();
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -20);
        Date Hour48Ago = cal.getTime();

        return createTime != null && createTime.before(Hour48Ago);
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
        orderInfoVO.setEmployerId(Context.getCurrEmployerId());
        orderInfoVO.setStatus(OrderStatus.WAITING_20.getCode());
        // search order info
        OrderInfo orderInfo = this.convert(orderInfoVO);
        if (StringUtils.isEmpty(orderInfo.getCode())) {
            orderInfo.setCode(CodeUtil.generateNewCode());
        }

        orderInfoService.save(orderInfo);

        OrderInfoDetail orderInfoDetail = createDetailInfo(orderInfoVO, orderInfo.getId());
        orderInfoDetailService.save(orderInfoDetail);

        // 写流水
        saveFollow(orderInfoVO);

        return ApiResponse.ofSuccess(true);
    }

    private OrderInfoDetail createDetailInfo(OrderInfoVO orderInfoVO, Long orderId) {
        OrderInfoDetail orderInfoDetail = new OrderInfoDetail();
        orderInfoDetail.setOrderId(orderId);
        orderInfoDetail.setProvinceCode(orderInfoVO.getProvinceCode());
        orderInfoDetail.setCityCode(orderInfoVO.getCityCode());
        orderInfoDetail.setDistrictCode(orderInfoVO.getDistrictCode());
        orderInfoDetail.setCountyCode(orderInfoVO.getCountyCode());
        orderInfoDetail.setSummarize(orderInfoVO.getSummarize());
        orderInfoDetail.setDescription(orderInfoVO.getDescription());

        return orderInfoDetail;
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
        orderFollow.setOperateUser(Context.getCurrUserId());
        orderFollow.setMemo(orderInfoVO.getMemo());
        orderFollowService.save(orderFollow);
    }

    @ApiOperation(value="订单信息变更")
    @ApiImplicitParam(paramType="body", name = "orderInfoVO", value = "订单信息变更", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderInfo",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateOrderInfo(OrderInfoVO orderInfoVO) {
        // 写流水
        saveFollow(orderInfoVO);

        return this.update(orderInfoVO);
    }

    private void fillJobInfo(OrderInfoVO orderInfoVO) {
        orderInfoVO.setJobCateName(bdJobCateService.getFullTreePathById(orderInfoVO.getJobCateId()));
    }

    private void fillJobInfos(List<OrderInfoVO> orderInfoVOs) {
        List<Long> cateIds = new ArrayList<>();
        for (OrderInfoVO orderInfoVO : orderInfoVOs) {
            cateIds.add(orderInfoVO.getJobCateId());
        }

        Map<Long, BdJobCate> jobCateMap = new HashMap<>();
        List<BdJobCate> bdJobCates = bdJobCateService.getByIds(cateIds);
        for (BdJobCate bdJobCate : bdJobCates) {
            jobCateMap.put(bdJobCate.getId(), bdJobCate);
        }

        for (OrderInfoVO orderInfoVO : orderInfoVOs) {
            if (jobCateMap.containsKey(orderInfoVO.getJobCateId())) {
                orderInfoVO.setJobCateName(jobCateMap.get(orderInfoVO.getJobCateId()).getCateName());
            }
        }
    }

    private OrderInfoVO fillUserInfo(OrderInfo orderInfo) {
        // get userInfo
        FreelancerInfo freelancerInfo = freelancerInfoService.get(orderInfo.getFreelancerId());
        EmployerInfo employerInfo = employerInfoService.get(orderInfo.getEmployerId());

        // fill userInfo
        OrderInfoVO orderInfoVO = super.convert(orderInfo);
        if (freelancerInfo != null) {
            FreelancerInfoApiVO freelancerInfoAppVO = new FreelancerInfoApiVO();
            freelancerInfoAppVO.setName(freelancerInfo.getName());
            freelancerInfoAppVO.setPhone(freelancerInfo.getPhone());

            orderInfoVO.setFreelancer(freelancerInfoAppVO);
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
