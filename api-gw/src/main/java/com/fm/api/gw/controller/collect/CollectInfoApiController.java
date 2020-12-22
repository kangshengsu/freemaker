package com.fm.api.gw.controller.collect;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.gw.vo.collect.CollectInfoVO;
import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.demand.mapper.DemandInfoMapper;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.enums.CollectStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.collect.CollectInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.collect.ICollectInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/21 18:36
 */
@RestController
@Api(description = "收藏接口")
@RequestMapping(value = "/v1/collectInfo")
public class CollectInfoApiController extends BaseController<CollectInfo, CollectInfoVO> {

    @Autowired
    private ICollectInfoService collectInfoService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private DemandInfoMapper demandInfoMapper;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ApiOperation(value = "收藏信息存储")
    public ApiResponse<Boolean> createCollectInfo(@RequestBody @Valid CollectInfoVO collectInfoVO){
        Long userId = Context.getCurrUserId();
        collectInfoVO.setUserId(userId);
        Long collect = collectInfoVO.getCollect();
        Long collectType = collectInfoVO.getCollectType();
        CollectInfo collectInfo = collectInfoService.getCollectInfo(userId, collect,collectType);
        if (ObjectUtil.isNotNull(collectInfo)) {
            if (collectInfo.getStatus() == CollectStatus.CANCEL_COLLECT.getCode()) {
                collectInfoVO.setId(collectInfo.getId());
                collectInfoVO.setStatus(CollectStatus.COLLECT.getCode());
              return success(collectInfoService.update(convert(collectInfoVO)));
            }
        }
        return success(collectInfoService.save(convert(collectInfoVO)));
    }

    @RequestMapping(value = "getCollectProduction",method = RequestMethod.GET)
    @ApiOperation(value = "获取作品收藏列表")
    public ApiResponse<CollectInfoVO> getCollectProduction(@RequestParam("currentPage")Integer currentPage,@RequestParam("pageSize")Integer pageSize){
        CollectInfoVO result = new CollectInfoVO();
        Long userId = Context.getCurrUserId();
        List<Long> productionId = collectInfoService.getProductionId(userId);
        Page<ProductionInfo> productionInfo = productionInfoService.getPageProductionById(productionId,currentPage, pageSize);
        if (CollectionUtils.isEmpty(productionInfo.getData())) {
            return failed("获取收藏列表失败");
        }
        List<ProductionViewVO> productionViewVOList = productionInfo.getData().stream().map(productionMapper::toProductionViewVO).collect(Collectors.toList());
        PageInfo<ProductionViewVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(productionInfo.getTotal());
        pageInfo.setData(productionViewVOList);
        result.setProductionInfo(pageInfo);
        return success(result);
    }

    @RequestMapping(value = "getCollectDemand",method = RequestMethod.GET)
    @ApiOperation(value = "获取需求收藏列表")
    public ApiResponse<CollectInfoVO> getCollectDemand(@RequestParam("currentPage")Integer currentPage,
                                                       @RequestParam("pageSize")Integer pageSize){
        CollectInfoVO result = new CollectInfoVO();
        Long userId = Context.getCurrUserId();
        List<Long> demandId = collectInfoService.getDemandId(userId);
        Page<DemandInfo> pageDemandInfo = demandInfoService.getPageDemandInfo(demandId, currentPage, pageSize);
        if (CollectionUtils.isEmpty(pageDemandInfo.getData())) {
            return failed("获取收藏列表失败");
        }
        List<DemandInfoVO> data = pageDemandInfo.getData().stream().map(demandInfoMapper::toDemandInfoVO).collect(Collectors.toList());
        PageInfo<DemandInfoVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(pageDemandInfo.getTotal());
        pageInfo.setData(data);
        result.setDemandInfo(pageInfo);
        return success(result);
    }

    @RequestMapping(value = "/updateStatus",method = RequestMethod.GET)
    @ApiOperation(value = "取消收藏接口")
    public ApiResponse<Boolean> updateStatus(@RequestParam("collect")Long collect,
                                             @RequestParam("collectType")Long collectType){
        Long userId = Context.getCurrUserId();
        CollectInfo collectInfo = collectInfoService.getCollectInfo(userId, collect,collectType);
        if (ObjectUtil.isNotNull(collectInfo)) {
            if (collectInfo.getStatus() == CollectStatus.COLLECT.getCode()) {
                collectInfo.setStatus(CollectStatus.CANCEL_COLLECT.getCode());
             return success(collectInfoService.update(collectInfo));
            }
        }
        return failed("取消收藏失败");
    }


    @Override
    protected Service<CollectInfo> service() {
        return collectInfoService;
    }
}
