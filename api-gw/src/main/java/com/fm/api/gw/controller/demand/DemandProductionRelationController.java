package com.fm.api.gw.controller.demand;

import com.fm.api.gw.vo.DirectRecommendVO;
import com.fm.api.gw.vo.RecommendVO;
import com.fm.api.gw.vo.demand.DemandProductionRelationVO;
import com.fm.business.base.enums.RecommendType;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/demandProductionRelationApi")
@Api(value = "需求中心自己直接推荐作品")
public class DemandProductionRelationController extends BaseController<DemandProductionRelation, DemandProductionRelationVO> {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    /**
     * 需求中心自己直接推荐作品
     * @param recommendVO
     * @return
     */
    @ApiOperation(value = "需求中心自己推荐作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandId", value = "需求Id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "productionIds", value = "作品Id", dataType = "List<Long>", paramType = "query")})
    @RequestMapping(value = "recommend", method = RequestMethod.POST)
    public ApiResponse<Boolean> recommend(@RequestBody DirectRecommendVO recommendVO) {
        demandProductionRelationService.recommend(recommendVO.getDemandId(), recommendVO.getProductionIds(), RecommendType.MY_RECOMMEND.getCode());
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "需求中心自己推荐作品时查询是否已推荐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandId", value = "需求Id", dataType = "Long", paramType = "query"),
    })
    @RequestMapping(value = "findRecommend", method = RequestMethod.GET)
    public ApiResponse<Boolean> findRecommend(Long demandId){
        Long currUserId = Context.getCurrUserId();
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(currUserId);
        List<ProductionInfo> productionInfoList = iProductionInfoService.findAllProduction(freelancerInfo.getId());
        List<Long> productionIds = productionInfoList.stream().map(ProductionInfo::getId).collect(Collectors.toList());
        List<DemandProductionRelation> result = demandProductionRelationService.findRecommend(productionIds, demandId);
        if(result.size() == 0){
            return ApiResponse.ofSuccess(Boolean.FALSE);
        }else {
            return ApiResponse.ofSuccess(Boolean.TRUE);
        }
    }


    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }
}
