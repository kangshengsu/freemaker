/**
 * @filename:BdJobCateController 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.api.gw.query.RecommendQueryRequest;
import com.fm.api.gw.vo.RecommendVO;
import com.fm.business.base.enums.DemandRecommendType;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 需求相关接口
 *
 */

@RestController
@RequestMapping("/v1/demandApi")
@Api(value = "推荐相关接口接口")
public class RecommendController extends BaseController<DemandProductionRelation, RecommendVO> {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @Autowired
    private IProductionInfoService productionInfoService;


    @RequestMapping(value = "getRecommendProductionInfoByDemandId", method = RequestMethod.GET)
    @ApiOperation(value = "根据需求id获取推荐的作品信息")
    public ApiResponse<List<ProductionInfo>> getRecommendProductionInfoByDemandId(@RequestParam("demandId") Long demandId) {
        List<DemandProductionRelation> demandProductionRelations = demandProductionRelationService.getByDemandId(demandId);
        List<Long> productionIds = demandProductionRelations.stream().map(DemandProductionRelation::getProductionId).collect(Collectors.toList());
        List<ProductionInfo> productionInfos = productionInfoService.getFullInfo(productionIds);
        return ApiResponse.ofSuccess(productionInfos);
    }

    @RequestMapping(value = "getRecommendInfoByDemandId", method = RequestMethod.GET)
    @ApiOperation(value = "获取推荐的作品信息分頁查詢")
    @ApiImplicitParam(paramType = "form", name = "recommendQueryRequest", value = "查询条件", required = true, dataType = "RecommendQueryRequest")
    public ApiResponse<Page<RecommendVO>> getRecommendInfoByDemandId(RecommendQueryRequest recommendQueryRequest) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("demandId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(recommendQueryRequest.getDemandId());
        queryItems.add(queryItem);

        Page<DemandProductionRelation> demandProductionRelationPage = demandProductionRelationService.list(queryItems, recommendQueryRequest.getCurrPage(), recommendQueryRequest.getPageSize());
        List<Long> productionIds = new ArrayList<>();
        for (DemandProductionRelation datum : demandProductionRelationPage.getData()) {
            productionIds.add(datum.getProductionId());
        }

        List<RecommendVO> recommendVOS = transRelation2RecommendVO(productionIds);
        return ApiResponse.ofSuccess(toRecommendPage(demandProductionRelationPage, recommendVOS));
    }

    private List<RecommendVO> transRelation2RecommendVO(List<Long> productionIds) {
        List<RecommendVO> recommendVOS = new ArrayList<>();
        RecommendVO recommendVO;
        List<ProductionInfo> productionInfos = productionInfoService.getByIds(productionIds);
        for (ProductionInfo productionInfo : productionInfos) {
            recommendVO = new RecommendVO();
            recommendVO.setCode(productionInfo.getCode());
            recommendVO.setJobCateId(productionInfo.getJobCateId());
            recommendVO.setStatus(productionInfo.getStatus());
            recommendVO.setStatusName(ProductionStatus.get(productionInfo.getStatus()).getName());
            recommendVO.setTitle(productionInfo.getTitle());
            recommendVO.setSummarize(productionInfo.getSummarize());

            recommendVOS.add(recommendVO);
        }

        return recommendVOS;
    }

    private Page<RecommendVO> toRecommendPage(Page page, List<RecommendVO> recommendVOS) {
        PageInfo<RecommendVO> pageInfo = new PageInfo<RecommendVO>();
        pageInfo.setCurrentPage(page.getCurrentPage());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setData(recommendVOS);

        return pageInfo;
    }

    @RequestMapping(value = "getReceivingRecommendInfoByDemandId", method = RequestMethod.GET)
    @ApiOperation(value = "获取接单的作品信息")
    @ApiImplicitParam(paramType = "form", name = "recommendQueryRequest", value = "查询条件", required = true, dataType = "RecommendQueryRequest")
    public ApiResponse<List<RecommendVO>> getReceivingRecommendInfoByDemandId(RecommendQueryRequest recommendQueryRequest) {
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

        List<DemandProductionRelation> demandProductionRelationList = demandProductionRelationService.get(queryItems);
        List<Long> productionIds = new ArrayList<>();
        for (DemandProductionRelation datum : demandProductionRelationList) {
            productionIds.add(datum.getProductionId());
        }
        return ApiResponse.ofSuccess(transRelation2RecommendVO(productionIds));
    }

    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }
}
