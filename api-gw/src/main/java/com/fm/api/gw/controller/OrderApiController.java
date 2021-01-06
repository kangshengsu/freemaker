/**
 * @filename:BdJobCateController 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.attachment.mapper.AttachmentMapper;
import com.fm.api.gw.vo.employer.mapper.EmployerInfoMapper;
import com.fm.api.gw.vo.freelancer.mapper.FreelancerInfoMapper;
import com.fm.api.gw.vo.order.OrderAmountVO;
import com.fm.api.gw.vo.order.OrderOperateInfoVO;
import com.fm.api.gw.vo.order.mapper.OrderAmountMapper;
import com.fm.api.gw.vo.order.mapper.OrderOperateMapper;
import com.fm.business.base.enums.*;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.*;
import com.fm.business.base.model.serviceCharge.ServiceCharge;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.order.*;
import com.fm.business.base.service.serviceCharge.IServiceChargeService;
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
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>说明： 岗位API接口层</p>
 *
 * @version: V1.0
 * @author: LiuDuo
 * @time 2020年09月11日
 */

@RestController
@RequestMapping("/v1/orderApi")
@Api(value = "订单接口")
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
    private FreelancerInfoMapper freelancerInfoMapper;

    @Autowired
    private EmployerInfoMapper employerInfoMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private OrderOperateMapper orderOperateMapper;

    @Autowired
    private IAttachmentInfoService attachmentInfoService;

    @Autowired
    private IServiceChargeService serviceChargeService;

    @Autowired
    private IOrderAmountService orderAmountService;

    @Autowired
    private OrderAmountMapper orderAmountMapper;

    @RequestMapping(value = "getOrderListByStakeholder", method = RequestMethod.GET)
    @ApiOperation(value = "根据订单参与者ID获取订单（订单参与者：雇主/自由职业者）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query")})
    public ApiResponse<Page<OrderInfoVO>> getOrderListByStakeholder(
            @RequestParam("currentPage") Integer currentPage
            , @RequestParam("pageSize") Integer pageSize
            , @RequestParam("orderType") Integer orderType
            , @RequestParam("status") Integer status) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();

        Page<OrderInfo> orderInfoPage = orderInfoService.queryOrderInfoByPage(currEmployerId, currFreelancerId, currentPage, pageSize, orderType, status);
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

    @ApiOperation(value = "根据主键获取订单")
    @ApiImplicitParam(paramType = "query", name = "code", value = "订单主键", required = true, dataType = "String")
    @RequestMapping(value = "getOrderInfoById", method = RequestMethod.GET)
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
        fillOrderOperateInfo(orderInfoVO);
        fillServiceChargeInfo(orderInfoVO);

        // belong to
        if (Context.getCurrEmployerId().equals(orderInfoVO.getEmployerId())) {
            orderInfoVO.setOrderBelongType(OrderOperateRoleType.EMPLOYER.getCode());
        } else if (Context.getCurrFreelancerId().equals(orderInfoVO.getFreelancerId())) {
            orderInfoVO.setOrderBelongType(OrderOperateRoleType.FREELANCER.getCode());
        }

        orderInfoVO.setCanChargeback(isHour48Ago(orderInfoVO.getId()));
        //IsUploadVoucher对应的数据库字段设置默认之后，可直接转换boolean
        orderInfoVO.setIsUploadVoucher(orderInfo.getIsUploadVoucher() == null ? Boolean.FALSE : BooleanUtils.toBoolean(orderInfo.getIsUploadVoucher()));

        return ApiResponse.ofSuccess(orderInfoVO);
    }

    private void fillServiceChargeInfo(OrderInfoVO orderInfoVO) {
        OrderAmount orderAmount = orderAmountService.getByOrderId(orderInfoVO.getId());
        OrderAmountVO orderAmountVO = orderAmountMapper.toOrderAmountVO(orderAmount);
//        String freelancerServiceCharge = orderAmountVO.getFreelancerServiceCharge() + "%";
//        orderAmountVO.setFreelancerServiceCharge(freelancerServiceCharge);
        orderInfoVO.setOrderAmount(orderAmountVO);
    }

    private void fillOrderOperateInfo(OrderInfoVO orderInfoVO) {
        List<OrderOperateInfo> orderOperateInfoList = orderOperateInfoService.findByOrderId(orderInfoVO.getId(), OrderOperateType.SUBMIT.getCode(), OrderOperateType.SUBMIT_AGAIN.getCode());
        orderInfoVO.setOrderOperateInfo(new ArrayList<>());
        HashSet<Long> freelancerIds = new HashSet<>();
        HashSet<String> businessCodes = new HashSet<>();
        List<OrderOperateInfoVO> operateInfoVOS = orderOperateInfoList.stream().map(orderOperateMapper::toOrderOperateInfoVO).collect(Collectors.toList());
        orderInfoVO.setOrderOperateInfo(operateInfoVOS);
        orderOperateInfoList.forEach(orderOperateInfo -> {
            businessCodes.add(orderOperateInfo.getId().toString());
            if (OrderOperateType.SUBMIT.getCode() == orderOperateInfo.getOperateType() || OrderOperateType.SUBMIT_AGAIN.getCode() == orderOperateInfo.getOperateType()) {
                freelancerIds.add(orderOperateInfo.getOperateUser());
            }
        });
        Map<String, List<AttachmentVO>> attachmentInfoMap = attachmentInfoService.getByCodeAndType(businessCodes, AttachmentBusinessType.ORDER_OPERATE).stream().collect(Collectors.toMap(AttachmentInfo::getBusinessCode, v -> {
            List<AttachmentVO> list = new ArrayList<>();
            AttachmentVO attachmentVO = attachmentMapper.toAttachmentVO(v);
            list.add(attachmentVO);
            return list;
        }, (v1, v2) -> {
            v1.addAll(v2);
            return v1;
        }));

        Map<Long, FreelancerInfo> freelancerInfoMap = freelancerInfoService.getByIds(freelancerIds).stream().collect(Collectors.toMap(FreelancerInfo::getId, Function.identity(), (v1, v2) -> v2));
        orderInfoVO.getOrderOperateInfo().forEach(orderOperateInfoVO -> {
            if (OrderOperateType.SUBMIT.getCode() == orderOperateInfoVO.getOperateType() || OrderOperateType.SUBMIT_AGAIN.getCode() == orderOperateInfoVO.getOperateType()) {
                if (attachmentInfoMap.containsKey(orderOperateInfoVO.getId().toString())) {
                    orderOperateInfoVO.setImages(attachmentInfoMap.get(orderOperateInfoVO.getId().toString()));
                }
                if (freelancerInfoMap.containsKey(orderOperateInfoVO.getOperateUser())) {
                    orderOperateInfoVO.setOperateUserName(freelancerInfoMap.get(orderOperateInfoVO.getOperateUser()).getName());
                }
            }
        });

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

    @ApiOperation(value = "下单")
    @ApiImplicitParam(paramType = "query", name = "code", value = "订单信息", required = true, dataType = "String")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody OrderInfoVO orderInfoVO) {
        orderInfoVO.setEmployerId(Context.getCurrEmployerId());
        orderInfoVO.setStatus(OrderStatus.WAITING_20.getCode());
        orderInfoVO.setActOrderMny(orderInfoVO.getActOrderMny());

        // search order info
        OrderInfo orderInfo = this.convert(orderInfoVO);
        if (StringUtils.isEmpty(orderInfo.getCode())) {
            orderInfo.setCode(CodeUtil.generateNewCode());
        }

        OrderInfoDetail orderInfoDetail = new OrderInfoDetail();
        orderInfoDetail.setProvinceCode(orderInfoVO.getProvinceCode());
        orderInfoDetail.setCityCode(orderInfoVO.getCityCode());
        orderInfoDetail.setDistrictCode(orderInfoVO.getDistrictCode());
        orderInfoDetail.setCountyCode(orderInfoVO.getCountyCode());
        orderInfoDetail.setSummarize(orderInfoVO.getSummarize());
        orderInfoDetail.setDescription(orderInfoVO.getDescription());

        orderInfo.setOrderInfoDetail(orderInfoDetail);
        List<ServiceCharge> serviceCharges = serviceChargeService.getAll();
        /**
         * 实际支付金额
         */
        Double actOrderMny = orderInfoVO.getActOrderMny();
        /**
         * 实收服务费
         */
        Double freelancerActServiceCharge = 0.0;
        if (serviceCharges.get(0).getFreelancerServiceCharge() > 0) {
            freelancerActServiceCharge = actOrderMny * ((double) serviceCharges.get(0).getFreelancerServiceCharge() / 100);
        }
        /**
         * 人才到手金额
         */
        Double freelancerActGetMny = actOrderMny - freelancerActServiceCharge;

        /**
         * 实收雇主服务费
         */
        Double employerActServiceCharge = 0.0;
        if (serviceCharges.get(0).getCompanyServiceCharge() > 0) {
             employerActServiceCharge = actOrderMny * ((double) serviceCharges.get(0).getCompanyServiceCharge() / 100);
        }
        /**
         * 雇主实际支付
         */
        Double employerActPayMny = employerActServiceCharge + actOrderMny;
        OrderAmount orderAmount = new OrderAmount();
        orderAmount.setFreelancerServiceCharge(serviceCharges.get(0).getFreelancerServiceCharge());
        orderAmount.setEmployerServiceCharge(serviceCharges.get(0).getCompanyServiceCharge());
        orderAmount.setFreelancerActServiceCharge(freelancerActServiceCharge);
        orderAmount.setEmployerActServiceCharge(employerActServiceCharge);
        orderAmount.setFreelancerActGetMny(freelancerActGetMny);
        orderAmount.setEmployerActPayMny(employerActPayMny);
        orderInfo.setActOrderMny(employerActPayMny);
        orderInfo.setOrderAmount(orderAmount);
        orderInfoService.save(orderInfo);

//        OrderInfoDetail orderInfoDetail1 = createDetailInfo(orderInfoVO, orderInfo.getId());
//        orderInfoDetailService.save(orderInfoDetail1);

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

    @ApiOperation(value = "订单状态变更")
    @ApiImplicitParam(paramType = "body", name = "orderInfoVO", value = "订单操作信息", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderStatus", method = RequestMethod.PUT)
    public ApiResponse<Boolean> updateOrderStatus(@RequestBody OrderInfoVO orderInfoVO) {
        this.update(orderInfoVO);

        // 写流水
        saveFollow(orderInfoVO);

        // 写操作表
        saveOperateInfo(orderInfoVO.getId(), orderInfoVO.getStatus(), orderInfoVO.getFollowDesc(), orderInfoVO.getAttachmentList());

        return ApiResponse.ofSuccess(true);
    }

    @ApiOperation(value = "订单金额变更")
    @ApiImplicitParam(paramType = "body", name = "orderInfoVO", value = "订单操作信息", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderMny", method = RequestMethod.PUT)
    public ApiResponse<Boolean> updateOrderMny(@RequestBody OrderInfoVO orderInfoVO) {
        Double actOrderMny = orderInfoVO.getActOrderMny();
        List<ServiceCharge> serviceCharges = serviceChargeService.getAll();
        /**
         * 实收服务费
         */
        Double freelancerActServiceCharge = 0.0;
        if (serviceCharges.get(0).getFreelancerServiceCharge() > 0) {
            freelancerActServiceCharge = actOrderMny * ((double) serviceCharges.get(0).getFreelancerServiceCharge() / 100);
        }
        /**
         * 人才到手金额
         */
        Double freelancerActGetMny = actOrderMny - freelancerActServiceCharge;

        /**
         * 实收雇主服务费
         */
        Double employerActServiceCharge = 0.0;
        if (serviceCharges.get(0).getCompanyServiceCharge() > 0) {
            employerActServiceCharge = actOrderMny * ((double) serviceCharges.get(0).getCompanyServiceCharge() / 100);
        }
        /**
         * 雇主实际支付
         */
        Double employerActPayMny = employerActServiceCharge + actOrderMny;
        orderInfoVO.setActOrderMny(employerActPayMny);
        this.update(orderInfoVO);
        OrderAmount orderAmount = orderAmountService.getByOrderId(orderInfoVO.getId());
        orderAmount.setFreelancerActServiceCharge(freelancerActServiceCharge);
        orderAmount.setEmployerActServiceCharge(employerActServiceCharge);
        orderAmount.setFreelancerActGetMny(freelancerActGetMny);
        orderAmount.setEmployerActPayMny(employerActPayMny);
        orderAmountService.update(orderAmount);
        // 写流水
        saveModifyFollow(orderInfoVO);
        return ApiResponse.ofSuccess(true);
    }

    @ApiOperation(value = "上传订单支付凭证（图片）")
    @ApiImplicitParam(paramType = "body", name = "orderInfoVO", value = "上传订单支付凭证", required = true, dataType = "String")
    @PostMapping(value = "uploadPayAttachment")
    public ApiResponse<Boolean> uploadPayAttachment(
            @RequestBody @Validated(value = {OrderOperateInfoVO.UploadPayAttachment.class}) OrderOperateInfoVO orderOperateInfoVO) {
        //上传前删除旧支付凭证记录
        if (orderOperateInfoVO.getId() != null) {
            orderOperateInfoService.delete(orderOperateInfoVO.getId());
        }
        OrderInfo orderInfo = orderInfoService.get(orderOperateInfoVO.getOrderId());
        // 新增操作表记录
        this.saveOperateInfo(orderOperateInfoVO.getOrderId(), orderInfo.getStatus(), null, orderOperateInfoVO.getImages());
        return ApiResponse.ofSuccess(true);
    }

    @ApiOperation(value = "获取订单支付凭证信息")
    @ApiImplicitParam(paramType = "query", name = "orderId", value = "获取订单支付凭证信息", required = true, dataType = "Long")
    @GetMapping(value = "getPaymentVoucherInfo")
    public ApiResponse<OrderOperateInfoVO> getPaymentVoucherInfo(@RequestParam("orderId") Long orderId) {
        List<OrderOperateInfo> orderOperateInfos = orderOperateInfoService.findByOrderId(orderId, OrderOperateType.SUBMIT_PAYMENT_VOUCHER.getCode());

        OrderOperateInfoVO result = Optional.ofNullable(orderOperateInfos)
                .filter(r -> !CollectionUtils.isEmpty(r))
                .map(r -> r.get(0))
                .map(s -> orderOperateMapper.toOrderOperateInfoVO(s))
                .orElse(null);

        return success(result);
    }

    private void saveOperateInfo(Long orderId, Integer status, String followDesc, List<AttachmentVO> attachmentList) {
        List<AttachmentInfo> attachmentInfos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(attachmentList)) {
            attachmentInfos.addAll(attachmentList.stream()
                    .map(attachmentVO -> attachmentMapper.toAttachment(attachmentVO))
                    .collect(Collectors.toList()));
        }
        orderOperateInfoService.saveOperateInfo(orderId, status, followDesc, attachmentInfos);
    }

    private void saveFollow(OrderInfoVO orderInfoVO) {
        this.saveFollow(orderInfoVO, FollowType.get(orderInfoVO.getStatus()).getCode());
    }

    private void saveModifyFollow(OrderInfoVO orderInfoVO) {
        this.saveFollow(orderInfoVO, FollowType.MODIFY_MNY_110.getCode());
    }

    private void saveFollow(OrderInfoVO orderInfoVO, Integer followType) {
        // 写流水
        OrderFollow orderFollow = new OrderFollow();
        orderFollow.setOrderId(orderInfoVO.getId());
        orderFollow.setOperateType(followType);
        orderFollow.setOperateUser(Context.getCurrUserId());
        orderFollow.setMemo(orderInfoVO.getMemo());
        orderFollowService.save(orderFollow);
    }

    @ApiOperation(value = "订单信息变更")
    @ApiImplicitParam(paramType = "body", name = "orderInfoVO", value = "订单信息变更", required = true, dataType = "OrderInfoVO")
    @RequestMapping(value = "updateOrderInfo", method = RequestMethod.POST)
    public ApiResponse<Boolean> updateOrderInfo(OrderInfoVO orderInfoVO) {
        // 写流水
        saveFollow(orderInfoVO);

        return this.update(orderInfoVO);
    }

    @ApiOperation(value = "获取订单验收不通过信息")
    @ApiImplicitParam(paramType = "query", name = "orderId", value = "获取订单验收不通过信息", required = true, dataType = "Long")
    @GetMapping(value = "getOrderUnAcceptInfo")
    public ApiResponse<List<OrderOperateInfoVO>> getOrderUnAcceptInfo(@RequestParam("orderId") Long orderId) {
        List<OrderOperateInfo> orderOperateInfos = orderOperateInfoService.findByOrderId(orderId, OrderOperateType.UNACCEPT.getCode());
        if (CollectionUtils.isEmpty(orderOperateInfos)) {
            return success(Collections.EMPTY_LIST);
        }
        return success(orderOperateInfos.stream().map(orderOperateInfo ->
                orderOperateMapper.toOrderOperateInfoVO(orderOperateInfo)).collect(Collectors.toList()));
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
            orderInfoVO.setFreelancer(freelancerInfoMapper.toFreelancerInfoApi(freelancerInfo));
        }

        if (employerInfo != null) {
            orderInfoVO.setEmployer(employerInfoMapper.toEmployerInfoApi(employerInfo));
        }

        return orderInfoVO;
    }

    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }
}
