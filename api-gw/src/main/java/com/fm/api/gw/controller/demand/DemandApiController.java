package com.fm.api.gw.controller.demand;

import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.demand.mapper.DemandInfoMapper;
import com.fm.business.base.enums.*;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangleqi
 * @date 2020-09-21 7:21 下午
 */
@RestController
@RequestMapping("/v1/demandApi")
@Api(value = "需求接口")
public class DemandApiController extends BaseController<DemandInfo, DemandInfoVO> {

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    @Autowired
    private DemandInfoMapper demandInfoMapper;

    @ApiOperation(value = "获取需求分页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "需求状态", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "demandStatus", value = "我的需求状态", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "getPageByEmployerId", method = RequestMethod.GET)
    public ApiResponse<Page<DemandInfoVO>> getPageByEmployerId(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam(value = "status", required = false) Integer status,
                                                               @RequestParam(value = "demandStatus", required = false) Integer demandStatus) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();
        List<ProductionInfo> productionInfoList = iProductionInfoService.findAllProduction(currFreelancerId);
        List<Long> productionIds = productionInfoList.stream().map(ProductionInfo::getId).collect(Collectors.toList());
        List<DemandProductionRelation> demandProductionRelations = demandProductionRelationService.findAllRecommendByStatus(productionIds, demandStatus);
        List<Long> demandProductionRelationIds = demandProductionRelations.stream().map(DemandProductionRelation::getDemandId).collect(Collectors.toList());
        PageInfo<DemandInfo> result = new PageInfo<>();
        if (demandStatus == 30) {
            Page<DemandInfo> pageByEmployerId = demandInfoService.getPageByEmployerId(currentPage, pageSize, status, currEmployerId);
            result.setCurrentPage(pageByEmployerId.getCurrentPage());
            result.setPageSize(pageByEmployerId.getPageSize());
            result.setTotal(pageByEmployerId.getTotal());
            result.setData(pageByEmployerId.getData());
        } else {
            if (!CollectionUtils.isEmpty(demandProductionRelations)) {
                Page<DemandInfo> pageByDemandStatus = demandInfoService.getPageByDemandStatus(currentPage, pageSize, status, demandProductionRelationIds);
                result.setCurrentPage(pageByDemandStatus.getCurrentPage());
                result.setPageSize(pageByDemandStatus.getPageSize());
                result.setTotal(pageByDemandStatus.getTotal());
                result.setData(pageByDemandStatus.getData());
            } else {
                result.setData(new ArrayList<>());
                return ApiResponse.ofSuccess(this.convert(result));
            }
        }
        //Page<DemandInfo> demandInfoPage = demandInfoService.gePageByEmployerId(currentPage, pageSize, currEmployerId, status, demandProductionRelationIds);
        result.getData().forEach(
                demandInfo -> {
                    if (demandInfo.getEmployerId().longValue() == currEmployerId.longValue()) {
                        demandInfo.setDemandStatus(RecommendType.MY_START.getCode());
                    } else {
                        demandProductionRelations.forEach(
                                demandProductionRelation -> {
                                    if (demandProductionRelation.getDemandId().longValue() == demandInfo.getId().longValue()) {
                                        demandInfo.setDemandStatus(RecommendType.get(demandProductionRelation.getStatus()).getCode());
                                    }
                                });

                    }
                });
        return success(this.convert(result));
    }

    @ApiOperation(value = "按领域获取已经发布的需求分页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "jobCateId", value = "领域id", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "getPageByJobCateId", method = RequestMethod.GET)
    public ApiResponse<Page<DemandInfoVO>> getPageByJobCateId(@RequestParam("currentPage") Integer currentPage,
                                                              @RequestParam("pageSize") Integer pageSize,
                                                              @RequestParam(value = "jobCateId", required = false) Integer jobCateId) {
        Long currEmployerId = Context.getCurrEmployerId();
        Page<DemandInfoVO> result = new PageInfo<>();
        Page<DemandInfo> demandInfoPage = demandInfoService.gePageByStatusJobCateId(currentPage, pageSize,
                currEmployerId, DemandStatus.RELEASE.getCode(), jobCateId);
        if (demandInfoPage.getData().size() == 0) {
            return ApiResponse.ofSuccess(result);
        }
        return success(this.convert(demandInfoPage));
    }

    @ApiOperation(value = "获取不同状态下的需求总数")
    @RequestMapping(value = "getDemandGroupCount", method = RequestMethod.GET)
    @ApiImplicitParams(@ApiImplicitParam(name = "demandStatus", value = "我的需求状态", dataType = "Integer", paramType = "query"))
    public ApiResponse<Map<String, Integer>> getDemandGroupCount(@RequestParam(value = "demandStatus", required = false) Integer demandStatus) {
        Long currEmployerId = Context.getCurrEmployerId();
        Long currFreelancerId = Context.getCurrFreelancerId();
        List<ProductionInfo> productionInfoList = iProductionInfoService.findAllProduction(currFreelancerId);
        List<Long> productionIds = productionInfoList.stream().map(ProductionInfo::getId).collect(Collectors.toList());
        List<DemandProductionRelation> demandProductionRelations = demandProductionRelationService.findAllRecommendByStatus(productionIds, demandStatus);
        List<Long> demandProductionRelationIds = demandProductionRelations.stream().map(DemandProductionRelation::getDemandId).collect(Collectors.toList());
        Integer openedCount;
        Integer closedCount;
        if (demandStatus == 30) {
            openedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.RELEASE.getCode());
            closedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.CANCEL.getCode());
        } else {
            if (CollectionUtils.isEmpty(demandProductionRelationIds)) {
                Map<String, Integer> map = new HashMap<>();
                map.put("total", 0);
                map.put("opened", 0);
                map.put("closed", 0);

                return success(map);
            }
            openedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.RELEASE.getCode(), demandProductionRelationIds);
            closedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.CANCEL.getCode(), demandProductionRelationIds);
        }

        Map<String, Integer> groupCount = new HashMap<>();
        groupCount.put("total", openedCount + closedCount);
        groupCount.put("opened", openedCount);
        groupCount.put("closed", closedCount);

        return success(groupCount);
    }

    @ApiOperation(value = "根据需求编码更新需求状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandCode", value = "需求编码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "updateStatus", method = RequestMethod.GET)
    public ApiResponse<Boolean> updateStatus(@RequestParam("demandCode") String demandCode, @RequestParam("status") Integer status) {
        demandInfoService.updateStatusByCode(demandCode, status);
        return success(Boolean.TRUE);
    }

    @ApiOperation(value = "根据需求编码获取需求明细信息")
    @ApiImplicitParam(name = "demandCode", value = "需求编码", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "getByCode", method = RequestMethod.GET)
    public ApiResponse<DemandInfoVO> getByCode(@RequestParam("demandCode") String demandCode) {
        if (StringUtils.isEmpty(demandCode)) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = demandInfoService.getByCode(demandCode);

        Long currUserId = Context.getCurrUserId();
        Long currEmployerId = Context.getCurrEmployerId();
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(currUserId);
        List<ProductionInfo> productionInfoList = iProductionInfoService.findAllProduction(freelancerInfo.getId());
        List<Long> productionIds = productionInfoList.stream().map(ProductionInfo::getId).collect(Collectors.toList());
        List<DemandProductionRelation> demandProductionRelations = demandProductionRelationService.findAllRecommend(productionIds);
        if (demandInfo.getEmployerId().longValue() == currEmployerId.longValue()) {
            demandInfo.setDemandStatus(RecommendType.MY_START.getCode());
        } else {
            demandProductionRelations.forEach(
                    demandProductionRelation -> {
                        if (demandProductionRelation.getDemandId().longValue() == demandInfo.getId().longValue()) {
                            demandInfo.setDemandStatus(RecommendType.get(demandProductionRelation.getStatus()).getCode());
                        }
                    });
        }

        return success(this.convert(demandInfo));
    }


    /**
     * 悬赏招聘测试数据
     *
     * @param { "demandType":20,
     *          "expectDeliveryTime":"2020-1-15",
     *          "summarize":"测试",
     *          "description":"测试1",
     *          "jobRequire":"岗位要求",
     *          "companyName":"无域未来",
     *          "salaryRange":"1-3",
     *          "educationRequire":"本科",
     *          "workExperience":"1-3年",
     *          "ageRequire":"18-45岁",
     *          "recommendAward":100,
     *          "recruitAmount":3,
     *          "sumMoney":300
     *          }
     * @return
     */
    @ApiOperation(value = "发布新需求")
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    public ApiResponse<String> publish(@RequestBody DemandInfoVO form) {
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setCompany(form.getCompanyName());
        employerInfo.setProvinceCode(form.getProvinceCode());
        employerInfo.setCityCode(form.getCityCode());
        employerInfo.setDistrictCode(form.getDistrictCode());
        employerInfo.setJobTitle(form.getJobTitle());

        form.setCode(CodeUtil.generateNewCode2yyMMddHH());
        form.setEmployerId(Context.getCurrEmployerId());
        ApiResponse<Boolean> booleanApiResponse = super.create(form);
        if (form.getDemandType() == DemandType.DEMAND.getCode()) {
            return ApiResponse.ofSuccess(form.getCode());
        }
        boolean updateCompanyName = iEmployerInfoService.updateCompanyName(form.getEmployerId(), employerInfo);
        if (ApiStatus.SUCCESS.getCode() == booleanApiResponse.getCode() && updateCompanyName) {
            return ApiResponse.ofSuccess(form.getCode());
        }
        return success(booleanApiResponse.getMessage());

    }

    @ApiOperation(value = "根据需求编码更新需求")
    @RequestMapping(value = "updateByCode", method = RequestMethod.POST)
    public ApiResponse<Boolean> updateByCode(@RequestBody DemandInfoVO demandInfoVO) {
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setCompany(demandInfoVO.getCompanyName());
        employerInfo.setJobTitle(demandInfoVO.getJobTitle());

        if (StringUtils.isEmpty(demandInfoVO.getCode())) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = this.convert(demandInfoVO);
        demandInfo.setAttestation(DemandAttestationType.NO_ATTESTATION.getCode());
        demandInfoService.updateByCode(demandInfo);
        DemandInfo d = demandInfoService.getByCode(demandInfoVO.getCode());
        iEmployerInfoService.updateCompanyName(d.getEmployerId(), employerInfo);
        return success(Boolean.TRUE);
    }


    @Override
    protected Service<DemandInfo> service() {
        return demandInfoService;
    }

    @Override
    protected DemandInfoVO convert(DemandInfo model) {
        if (Objects.isNull(model)) {
            return null;
        }
        DemandInfoVO form = demandInfoMapper.toDemandInfoVO(model);
        //转换枚举值
        form.setStatusName(DemandStatus.get(model.getStatus()).getName());
        form.setDeliveryTypeName(DeliveryType.getNameByCode(model.getDeliveryType()));
        form.setBudgetTypeName(BudgetType.getNameByCode(model.getBudgetType()));
        //获取作者数据
        EmployerInfo employerInfo = iEmployerInfoService.get(model.getEmployerId());
        if (employerInfo != null) {
            form.setEmployerName(employerInfo.getName());
        }
        //获取需求信息
        BdJobCate bdJobCate = iBdJobCateService.get(model.getJobCateId());
        if (bdJobCate != null) {
            form.setJobCateIdName(bdJobCate.getCateName());
        }
        form.setOrderCount(iOrderInfoService.getOrderCountByDemandId(form.getId()));
        return form;
    }


}
