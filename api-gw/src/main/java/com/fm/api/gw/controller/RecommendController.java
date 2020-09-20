/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.enums.DemandRecommendType;
import com.fm.api.gw.query.RecommendQueryRequest;
import com.fm.api.gw.vo.DemandProductionRelationVO;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
*
* 需求相关接口
*
*/

@RestController
@RequestMapping("/miniApp/demandApi")
@Api(value = "需求接口")
public class RecommendController extends BaseController<DemandProductionRelation, DemandProductionRelationVO> {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @RequestMapping(value = "getRecommendInfoByDemandId",method = RequestMethod.GET)
    @ApiOperation(value="获取推荐的作品信息分頁查詢")
    @ApiImplicitParam(paramType="form", name = "recommendQueryRequest", value = "查询条件", required = true, dataType = "RecommendQueryRequest")
    public ApiResponse<Page<DemandProductionRelation>> getRecommendInfoByDemandId(RecommendQueryRequest recommendQueryRequest) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("demandId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(recommendQueryRequest.getDemandId());
        queryItems.add(queryItem);

        Page<DemandProductionRelation> demandProductionRelationPage = demandProductionRelationService.list(queryItems, recommendQueryRequest.getCurrPage(), recommendQueryRequest.getPageSize());
        return ApiResponse.ofSuccess(demandProductionRelationPage);
    }

    @RequestMapping(value = "getReceivingRecommendInfoByDemandId",method = RequestMethod.GET)
    @ApiOperation(value="获取接单的作品信息")
    @ApiImplicitParam(paramType="form", name = "recommendQueryRequest", value = "查询条件", required = true, dataType = "RecommendQueryRequest")
    public ApiResponse<List<DemandProductionRelation>> getReceivingRecommendInfoByDemandId(RecommendQueryRequest recommendQueryRequest) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("demandId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(recommendQueryRequest.getDemandId());
        queryItems.add(queryItem);

        queryItem = new QueryItem();
        queryItem.setQueryField("status");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(DemandRecommendType.RECEIVING.getType());
        queryItems.add(queryItem);

        List<DemandProductionRelation> demandProductionRelationPage = demandProductionRelationService.get(queryItems);
        return ApiResponse.ofSuccess(demandProductionRelationPage);
    }

    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }
}
