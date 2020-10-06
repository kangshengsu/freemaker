/**
* @filename:OrderInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.order;

import com.fm.api.web.vo.job.BdJobTagVO;
import com.fm.api.web.vo.order.OrderInfoVO;
import com.fm.api.web.vo.order.OrderOperateInfoVO;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.OrderOperateType;
import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderFollowService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.order.IOrderOperateInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    private IOrderFollowService orderFollowService;

    @Autowired
    private IOrderOperateInfoService orderOperateInfoService;

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
        orderFollowService.saveOperateFollow(this.convert(form));
        return result;
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<OrderInfoVO>> list(@RequestBody QueryRequest queryRequest) {
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

    private void fillOperateInfo(OrderInfoVO orderInfoVO) {
        QueryItem item = new QueryItem();
        item.setQueryField("orderId");
        item.setValue(orderInfoVO.getId());
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);

        List<OrderOperateInfo> orderOperateInfos = orderOperateInfoService.get(queryList);
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

            orderInfoVO.setStatusName(OrderStatus.get(orderInfoVO.getStatus()).getName());
        }
    }

    private List<OrderInfoDetail> getOrderDetailByOrderIds(List<Long> orderIds) {
        QueryItem item = new QueryItem();
        item.setQueryField("orderId");
        item.setValue(orderIds);
        item.setType(QueryType.in);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);

        return orderInfoDetailService.get(queryList);
    }


    @Override
    protected Service<OrderInfo> service() {
        return orderInfoService;
    }

}
