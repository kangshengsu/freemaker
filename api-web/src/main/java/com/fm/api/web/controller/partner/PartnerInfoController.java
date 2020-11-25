package com.fm.api.web.controller.partner;

import com.fm.api.web.vo.partner.PartnerInfoVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.partner.DistributionPartnerInfo;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.partner.PartnerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.OrderItem;
import com.fm.framework.core.query.OrderType;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partner/partnerInfo")
public class PartnerInfoController extends BaseController<PartnerInfo, PartnerInfoVO> {

    @Autowired
    private PartnerInfoService partnerInfoService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    @Override
    protected Service<PartnerInfo> service() {
        return partnerInfoService;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<PartnerInfoVO>> list(@RequestBody QueryRequest queryRequest){
    queryRequest.getQueryItems().forEach( queryItem -> {
        if(queryItem.getQueryField().equals("phone")){
            List<String> phones = Arrays.asList(queryItem.getValue().toString().split(","));
            List<FreelancerInfo> userByPhones = iFreelancerInfoService.findUserByPhones(phones);
            List<Long> res = userByPhones.stream().map(FreelancerInfo::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(res)){
                queryItem.setQueryField("freelancerId");
                queryItem.setValue("");
                queryItem.setType(QueryType.eq);
            }else {
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(res);
                queryItem.setType(QueryType.in);
            }
        }
        if(queryItem.getQueryField().equals("status")){

            List<Integer> list = new ArrayList<>();
            list.add(ProductionStatus.RELEASE.getCode());
            List<ProductionInfo> allByStatus = iProductionInfoService.findAllByStatus(list);
            List<Long> allExistReleaseProduction = allByStatus.stream().map(ProductionInfo::getFreelancerId).collect(Collectors.toList());

            List<ProductionInfo> productionInfos = iProductionInfoService.getAll();
            List<Long> allExistProduction = productionInfos.stream().map(ProductionInfo::getFreelancerId).distinct().collect(Collectors.toList());

            if(queryItem.getValue().equals(ProductionStatus.RELEASE.getCode())){
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(allExistReleaseProduction);
                queryItem.setType(QueryType.in);
            }
            if(queryItem.getValue().equals(ProductionStatus.NOT_RELEASE.getCode())){
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(allExistProduction);
                queryItem.setType(QueryType.notIn);
            }
            if(queryItem.getValue().equals(ProductionStatus.REVIEW_NOT_PASS.getCode()) || queryItem.getValue().equals(ProductionStatus.REVIEW.getCode())){
                List<PartnerInfo> result = partnerInfoService.findNotExistProduction(allExistProduction);
                List<Long> allNotExistReleaseProduction = result.stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
                allExistReleaseProduction.addAll(allNotExistReleaseProduction);
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(allExistReleaseProduction);
                queryItem.setType(QueryType.notIn);
            }
        }
    });

        OrderItem orderItem = new OrderItem(OrderType.desc, "createTime");
        queryRequest.setOrderItem(orderItem);
        ApiResponse<Page<PartnerInfoVO>> list = super.list(queryRequest);
        return super.list(queryRequest);
    }

    @RequestMapping(value = "/distribution",method = RequestMethod.POST)
    public ApiResponse<Boolean> distribution(@RequestBody DistributionPartnerInfo distributionPartnerInfo){
        List<Long> collect = distributionPartnerInfo.getPartnerInfoList().stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
        boolean b = partnerInfoService.setPartner(collect, distributionPartnerInfo.getPartnerId());
        return ApiResponse.ofSuccess(b);
    }

    @Override
    protected PartnerInfoVO convert(PartnerInfo model) {
        PartnerInfoVO partnerInfoVO = super.convert(model);

        List<ProductionInfo> productionInfos = iProductionInfoService.findByFreeLancer(model.getFreelancerId());
        if(CollectionUtils.isEmpty(productionInfos)){
            partnerInfoVO.setProductionStatus(ProductionStatus.NOT_RELEASE.getCode());
        }else {
            List<ProductionInfo> byStatus = iProductionInfoService.findByStatus(model.getFreelancerId(), ProductionStatus.RELEASE.getCode());
            if(!CollectionUtils.isEmpty(byStatus)){
                partnerInfoVO.setProductionStatus(ProductionStatus.RELEASE.getCode());
            }else {
                partnerInfoVO.setProductionStatus(ProductionStatus.REVIEW_NOT_PASS.getCode());
            }
        }

        FreelancerInfo freelancerInfo = iFreelancerInfoService.get(model.getFreelancerId());
        partnerInfoVO.setFreelancerInfo(freelancerInfo);
        return partnerInfoVO;
    }
}
