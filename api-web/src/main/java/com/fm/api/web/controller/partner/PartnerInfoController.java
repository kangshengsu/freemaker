package com.fm.api.web.controller.partner;

import com.fm.api.web.vo.partner.PartnerInfoVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.educationInfo.EducationInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.partner.DistributionPartnerInfo;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.model.workInfo.WorkInfo;
import com.fm.business.base.service.educationInfo.EducationInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.partner.PartnerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.business.base.service.workInfo.WorkInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.*;
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

    @Autowired
    private IUserService iUserService;

    @Autowired
    private EducationInfoService educationInfoService;

    @Autowired
    private WorkInfoService workInfoService;



    @Override
    protected Service<PartnerInfo> service() {
        return partnerInfoService;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<PartnerInfoVO>> list(@RequestBody QueryRequest queryRequest){
        //根据不同权限展示不同数据
        User user = iUserService.findById(Context.getCurrUserId());
        user.getRoles().forEach(role -> {
            if(!role.getCode().contains("admin")){
                List<PartnerInfo> partnerInfos = partnerInfoService.findByBelongId(Long.valueOf(user.getCode()));
                List<Long> collect = partnerInfos.stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
                QueryItem queryItem = new QueryItem();
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(collect);
                queryItem.setType(QueryType.in);
                queryRequest.getQueryItems().add(queryItem);
            }
            if(role.getCode().contains("admin") && !role.getCode().equals("admin")){
                List<User> allByOrgId = iUserService.findAllByOrgId(user.getOrgId());
                List<String> collect1 = allByOrgId.stream().map(User::getCode).collect(Collectors.toList());
                List<Long> collect2 = collect1.stream().map(Long::valueOf).collect(Collectors.toList());
                List<PartnerInfo> partnerInfos = partnerInfoService.findByBelongIds(collect2);
                List<Long> collect = partnerInfos.stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
                QueryItem queryItem = new QueryItem();
                queryItem.setQueryField("freelancerId");
                queryItem.setValue(collect);
                queryItem.setType(QueryType.in);
                queryRequest.getQueryItems().add(queryItem);
            }
        });
        queryRequest.getQueryItems().forEach( queryItem -> {
            if(queryItem.getQueryField().equals("settlementTime")){
                queryItem.setValue(queryItem.getValue());
                queryItem.setType(QueryType.like);
            }
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
        return super.list(queryRequest);
    }

    @RequestMapping(value = "/settlement",method = RequestMethod.POST)
    public ApiResponse<Boolean> settlement(@RequestBody List<PartnerInfo> partnerInfos){
        List<Long> collect = partnerInfos.stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
        boolean result = partnerInfoService.settlement(collect);
        return ApiResponse.ofSuccess(result);
    }

    @RequestMapping(value = "/distribution",method = RequestMethod.POST)
    public ApiResponse<Boolean> distribution(@RequestBody DistributionPartnerInfo distributionPartnerInfo){
        List<Long> collect = distributionPartnerInfo.getPartnerInfoList().stream().map(PartnerInfo::getFreelancerId).collect(Collectors.toList());
        FreelancerInfo freelancerInfo = iFreelancerInfoService.get(distributionPartnerInfo.getPartnerId());
        boolean result = partnerInfoService.distribution(collect, freelancerInfo.getUserId());
        return ApiResponse.ofSuccess(result);
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

        List<EducationInfo> educationInfos = educationInfoService.getByFreelancerId(model.getFreelancerId());
        List<WorkInfo> workInfos = workInfoService.getByFreelancerId(model.getFreelancerId());
        partnerInfoVO.setEducationInfos(educationInfos);
        partnerInfoVO.setWorkInfos(workInfos);

        FreelancerInfo freelancerInfo = iFreelancerInfoService.get(model.getFreelancerId());
        partnerInfoVO.setFreelancerInfo(freelancerInfo);
        return partnerInfoVO;
    }
}
