package com.fm.api.web.controller.order;

import com.fm.api.web.vo.AttachmentInfoVO;
import com.fm.api.web.vo.mapper.AttachmentMapper;
import com.fm.api.web.vo.order.OrderInfoVO;
import com.fm.api.web.vo.order.OrderOperateInfoVO;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.FollowType;
import com.fm.business.base.enums.OrderOperateType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderFollow;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.order.IOrderOperateInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.*;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
*
* <p>说明： 订单信息API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/order/orderInfo")
public class OrderInfoController extends BaseController<OrderInfo, OrderInfoVO> {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;

    @Autowired
    private IOrderOperateInfoService orderOperateInfoService;

    @Autowired
    private IOrderFollowService orderFollowService;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @Autowired
    private IAttachmentInfoService attachmentInfoService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private AttachmentMapper attachmentMapper;


    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody OrderInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody OrderInfoVO form) {
        ApiResponse<Boolean> result = super.update(form);
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<OrderInfoVO>> list(@RequestBody QueryRequest queryRequest) {
        OrderItem orderItem = new OrderItem(OrderType.desc, "createTime");
        queryRequest.setOrderItem(orderItem);
        ApiResponse<Page<OrderInfoVO>> result = super.list(queryRequest);
        fillDetailInfo(result.getData().getData());

        return result;
    }

    @RequestMapping(value = "getOrderById",method = RequestMethod.GET)
    public ApiResponse<OrderInfoVO> getOrderById(Long id) {
        OrderInfoVO orderInfoVO = this.convert(orderInfoService.get(id));
        fillDetailInfo(Arrays.asList(orderInfoVO));
        fillOperateInfo(orderInfoVO);

        return this.success(orderInfoVO);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody OrderInfoVO orderInfoVO){
        ProductionInfo productionInfo = productionInfoService.getByCode(orderInfoVO.getProductionCode());
        EmployerInfo employerInfo = employerInfoService.get(orderInfoVO.getEmployerId());
        if( productionInfo == null ){
            return ApiResponse.ofFailed("请检查作品编码");
        }
        BdJobCate bdJobCate = iBdJobCateService.get(productionInfo.getJobCateId());
        orderInfoVO.setStatus(OrderStatus.WAITING_20.getCode());
        orderInfoVO.setProductionId(productionInfo.getId());
        orderInfoVO.setJobCateId(productionInfo.getJobCateId());
        orderInfoVO.setCateTreeCode(bdJobCate.getCateCode());
        orderInfoVO.setBudgetType(productionInfo.getBudgetType());
        orderInfoVO.setFreelancerId(productionInfo.getFreelancerId());

        OrderInfo orderInfo = this.convert(orderInfoVO);
        if (StringUtils.isEmpty(orderInfo.getCode())) {
            orderInfo.setCode(CodeUtil.generateNewCode());
        }

        OrderInfoDetail orderInfoDetail = new OrderInfoDetail();
        orderInfoDetail.setProvinceCode(employerInfo.getProvinceCode());
        orderInfoDetail.setCityCode(employerInfo.getCityCode());
        orderInfoDetail.setDistrictCode(employerInfo.getDistrictCode());
        orderInfoDetail.setCountyCode(employerInfo.getCountyCode());
        orderInfoDetail.setSummarize(orderInfoVO.getSummarize());
        orderInfoDetail.setDescription(orderInfoVO.getDescription());

        orderInfo.setOrderInfoDetail(orderInfoDetail);

        orderInfoService.save(orderInfo);

        // 写流水
        saveFollow(orderInfoVO);

        return ApiResponse.ofSuccess(true);
    }

    /**
     * 订单状态变更
     * @param orderInfoVO
     * @return
     */
    @RequestMapping(value = "updateOrderStatus",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateOrderStatus(@RequestBody OrderInfoVO orderInfoVO) {
        Integer status = orderInfoVO.getStatus();
        if(status.equals(OrderOperateType.RECEIVE.getCode()) || status.equals(OrderOperateType.SUBMIT_PAYMENT_VOUCHER.getCode())){
            orderInfoVO.setStatus(OrderStatus.TAKING_40.getCode());
        }
        if(status.equals(OrderOperateType.SUBMIT.getCode())){
            orderInfoVO.setStatus(OrderStatus.CHECKING_60.getCode());
        }
        if(status.equals(OrderOperateType.ACCEPT.getCode())){
            orderInfoVO.setStatus(OrderStatus.FINISHED_80.getCode());
        }
        if(status.equals(OrderOperateType.UNACCEPT.getCode())){
            orderInfoVO.setStatus(OrderStatus.CHECK_FAIL_70.getCode());
        }
        if(status.equals(OrderOperateType.SUBMIT_AGAIN.getCode())){
            orderInfoVO.setStatus(OrderStatus.CHECK_FAIL_61.getCode());
        }

        this.update(orderInfoVO);

        // 写流水
        saveFollow(orderInfoVO);

        // 写操作表
        saveOperateInfo(orderInfoVO.getEmployerId(), orderInfoVO.getFreelancerId(), orderInfoVO.getId(), status, orderInfoVO.getFollowDesc(), orderInfoVO.getAttachmentList());

        return ApiResponse.ofSuccess(true);
    }

    private void fillOperateInfo(OrderInfoVO orderInfoVO) {
        QueryItem item = new QueryItem();
        item.setQueryField("orderId");
        item.setValue(orderInfoVO.getId());
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);

        OrderItem orderItem = new OrderItem(OrderType.asc, "createTime");

        List<OrderOperateInfo> orderOperateInfos = orderOperateInfoService.get(queryList, orderItem);
        orderInfoVO.setOrderOperateInfos(new ArrayList<>());
        OrderOperateInfoVO temp;
        List<Long> employerIds = new ArrayList<>();
        List<Long> freelancerIds = new ArrayList<>();
        List<String> businessCodes = new ArrayList<>();
        for (OrderOperateInfo orderOperateInfo : orderOperateInfos) {
            businessCodes.add(orderOperateInfo.getId().toString());
            temp = new OrderOperateInfoVO();
            BeanUtils.copyProperties(orderOperateInfo, temp);
            orderInfoVO.getOrderOperateInfos().add(temp);

            if (OrderOperateType.SUBMIT.getCode().equals(orderOperateInfo.getOperateType())) {
                freelancerIds.add(orderOperateInfo.getOperateUser());
            } else {
                employerIds.add(orderOperateInfo.getOperateUser());
            }

            temp.setOperateTypeName(OrderOperateType.get(orderOperateInfo.getOperateType()).getName());
        }

        List<AttachmentInfo> attachmentInfos = attachmentInfoService.getByCodeAndType(businessCodes, AttachmentBusinessType.ORDER_OPERATE);
        Map<String, List<AttachmentInfo>> attachmentInfoMap = new HashMap<>();
        for (AttachmentInfo attachmentInfo : attachmentInfos) {
            if (!attachmentInfoMap.containsKey(attachmentInfo.getBusinessCode())) {
                attachmentInfoMap.put(attachmentInfo.getBusinessCode(), new ArrayList<>());
            }

            attachmentInfoMap.get(attachmentInfo.getBusinessCode()).add(attachmentInfo);
        }

        List<FreelancerInfo> freelancerInfos = freelancerInfoService.getByIds(freelancerIds);
        List<EmployerInfo> employerInfos = employerInfoService.getByIds(employerIds);
        Map<Long, FreelancerInfo> freelancerInfoMap = new HashMap();
        Map<Long, EmployerInfo> employerInfoMap = new HashMap();
        for (FreelancerInfo freelancerInfo : freelancerInfos) {
            freelancerInfoMap.put(freelancerInfo.getId(), freelancerInfo);
        }

        for (EmployerInfo employerInfo : employerInfos) {
            employerInfoMap.put(employerInfo.getId(), employerInfo);
        }

        for (OrderOperateInfoVO orderOperateInfoVO : orderInfoVO.getOrderOperateInfos()) {
            if (OrderOperateType.SUBMIT.getCode().equals(orderOperateInfoVO.getOperateType())) {
                if (freelancerInfoMap.containsKey(orderOperateInfoVO.getOperateUser())) {
                    orderOperateInfoVO.setOperateUserName(freelancerInfoMap.get(orderOperateInfoVO.getOperateUser()).getName());
                }

            } else {
                if (employerInfoMap.containsKey(orderOperateInfoVO.getOperateUser())) {
                    orderOperateInfoVO.setOperateUserName(employerInfoMap.get(orderOperateInfoVO.getOperateUser()).getName());
                }
            }

            if (attachmentInfoMap.containsKey(orderOperateInfoVO.getId().toString())) {
                orderOperateInfoVO.setAttachmentInfos(attachmentInfoMap.get(orderOperateInfoVO.getId().toString()));
            } else {
                orderOperateInfoVO.setAttachmentInfos(new ArrayList<>());
            }
        }

    }

    private void fillDetailInfo(List<OrderInfoVO> orderInfoVOS) {
        List<Long> freelancerIds = new ArrayList<>();
        List<Long> employerIds = new ArrayList<>();
        List<Long> demandIds = new ArrayList<>();
        List<Long> orderIds = new ArrayList<>();
        List<Long> jobCateIds = new ArrayList<>();
        for (OrderInfoVO orderInfoVO : orderInfoVOS) {
            orderIds.add(orderInfoVO.getId());
            demandIds.add(orderInfoVO.getDemandId());
            freelancerIds.add(orderInfoVO.getFreelancerId());
            employerIds.add(orderInfoVO.getEmployerId());
            jobCateIds.add(orderInfoVO.getJobCateId());
        }

        List<DemandInfo> demandInfos = demandInfoService.getByIds(demandIds);
        List<OrderInfoDetail> orderDetails = orderInfoDetailService.getOrderDetailByOrderIds(orderIds);
        List<FreelancerInfo> freelancerInfos = freelancerInfoService.getByIds(freelancerIds);
        List<EmployerInfo> employerInfos = employerInfoService.getByIds(employerIds);
        List<BdJobCate> bdJobCates = iBdJobCateService.getByIds(jobCateIds);
        Map<Long, BdJobCate> bdJobCateMap = new HashMap<>();
        Map<Long, DemandInfo> demandInfoMap = new HashMap<>();
        Map<Long, OrderInfoDetail> orderInfoDetailMap = new HashMap<>();
        Map<Long, FreelancerInfo> freelancerInfoMap = new HashMap<>();
        Map<Long, EmployerInfo> employerInfoMap = new HashMap<>();
        for (BdJobCate bdJobCate : bdJobCates) {
            bdJobCateMap.put(bdJobCate.getId(), bdJobCate);
        }
        for (DemandInfo demandInfo : demandInfos) {
            demandInfoMap.put(demandInfo.getId(), demandInfo);
        }
        for (OrderInfoDetail orderInfoDetail : orderDetails) {
            orderInfoDetailMap.put(orderInfoDetail.getOrderId(),orderInfoDetail);
        }
        for (FreelancerInfo freelancerInfo : freelancerInfos) {
            freelancerInfoMap.put(freelancerInfo.getId(), freelancerInfo);
        }
        for (EmployerInfo employerInfo : employerInfos) {
            employerInfoMap.put(employerInfo.getId(), employerInfo);
        }

        List<OrderInfoDetail> orderInfoDetails = getOrderDetailByOrderIds(orderIds);
        Map<Long, OrderInfoDetail> detailMap = new HashMap();
        for (OrderInfoDetail orderInfoDetail : orderInfoDetails) {
            detailMap.put(orderInfoDetail.getOrderId(), orderInfoDetail);
        }


        for (OrderInfoVO orderInfoVO : orderInfoVOS) {
            if (bdJobCateMap.containsKey(orderInfoVO.getJobCateId())) {
                orderInfoVO.setJobCateName(bdJobCateMap.get(orderInfoVO.getJobCateId()).getCateName());
            }
            if(orderInfoDetailMap.containsKey(orderInfoVO.getId())){
                orderInfoVO.setOrderInfoDetail(orderInfoDetailMap.get(orderInfoVO.getId()));
            }
            if (demandInfoMap.containsKey(orderInfoVO.getDemandId())) {
                orderInfoVO.setDemandSummarize(demandInfoMap.get(orderInfoVO.getDemandId()).getSummarize());
            }

            if (freelancerInfoMap.containsKey(orderInfoVO.getFreelancerId())) {
                orderInfoVO.setFreelancerName(freelancerInfoMap.get(orderInfoVO.getFreelancerId()).getName());
            }

            if (employerInfoMap.containsKey(orderInfoVO.getEmployerId())) {
                orderInfoVO.setEmployerName(employerInfoMap.get(orderInfoVO.getEmployerId()).getName());
            }

            if (detailMap.containsKey(orderInfoVO.getId())) {
                orderInfoVO.setSummarize(detailMap.get(orderInfoVO.getId()).getSummarize()  );
                orderInfoVO.setDescription(detailMap.get(orderInfoVO.getId()).getDescription());
            }

            orderInfoVO.setStatusName(OrderStatus.get(orderInfoVO.getStatus())!=null?OrderStatus.get(orderInfoVO.getStatus()).getName():"未知");
        }
    }

    private List<OrderInfoDetail> getOrderDetailByOrderIds(List<Long> orderIds) {
        if (CollectionUtils.isEmpty(orderIds)) {
            return Collections.EMPTY_LIST;
        }
        QueryItem item = new QueryItem();
        item.setQueryField("orderId");
        item.setValue(orderIds);
        item.setType(QueryType.in);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);

        return orderInfoDetailService.get(queryList);
    }

    private void saveFollow(OrderInfoVO orderInfoVO) {
        this.saveFollow(orderInfoVO, FollowType.get(orderInfoVO.getStatus()).getCode());
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

    private void saveOperateInfo(Long employerId, Long freelancerId, Long orderId, Integer status, String followDesc, List<AttachmentInfoVO> attachmentList) {
        List<AttachmentInfo> attachmentInfos = new ArrayList<>();
        if(!CollectionUtils.isEmpty(attachmentList)){
            attachmentInfos.addAll(attachmentList.stream()
                    .map(attachmentInfoVO -> attachmentMapper.toAttachment(attachmentInfoVO))
                    .collect(Collectors.toList()));
        }
        orderOperateInfoService.saveOperateInfoBack(employerId, freelancerId, orderId, status, followDesc, attachmentInfos);
    }

    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }

}
