package com.fm.api.gw.controller.demand;

import com.fm.api.gw.vo.DirectRecommendVO;
import com.fm.api.gw.vo.RecommendVO;
import com.fm.api.gw.vo.demand.DemandProductionRelationVO;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
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

@RestController
@RequestMapping("/v1/demandProductionRelationApi")
@Api(value = "需求中心直接推荐作品")
public class DemandProductionRelationController extends BaseController<DemandProductionRelation, DemandProductionRelationVO> {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    /**
     * 需求中心直接推荐作品status=10，后台分配为20
     * @param recommendVO
     * @return
     */
    @ApiOperation(value = "需求中心直接推荐作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandId", value = "需求Id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "productionIds", value = "作品Id", dataType = "List<Long>", paramType = "query")})
    @RequestMapping(value = "recommend",method = RequestMethod.POST)
    public ApiResponse<Boolean> recommend(@RequestBody DirectRecommendVO recommendVO) {
        Integer status = 20;
        demandProductionRelationService.recommend(recommendVO.getDemandId(), recommendVO.getProductionIds(), status);
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }


    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }
}
