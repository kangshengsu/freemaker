package com.fm.api.gw.controller.collect;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.gw.vo.collect.CollectInfoVO;
import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.demand.mapper.DemandInfoMapper;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.enums.*;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.collect.CollectInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.collect.ICollectInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.ap.shaded.freemarker.template.utility.DeepUnwrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
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

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ApiOperation(value = "收藏信息存储")
    public ApiResponse<CollectInfoVO> createCollectInfo(@RequestBody @Valid CollectInfoVO collectInfoVO) {
        Long userId = Context.getCurrUserId();
        collectInfoVO.setUserId(userId);
        Long collect = collectInfoVO.getCollect();
        Long collectType = collectInfoVO.getCollectType();
        CollectInfo collectInfo = collectInfoService.getCollectInfo(userId, collect, collectType);
        if (ObjectUtil.isNotNull(collectInfo)) {
            if (collectInfo.getStatus() == CollectStatus.CANCEL_COLLECT.getCode()) {
                collectInfoVO.setId(collectInfo.getId());
                collectInfoVO.setStatus(CollectStatus.COLLECT.getCode());
                if (collectInfoService.update(convert(collectInfoVO))) {
                    return success(collectInfoVO);
                } else {
                    return failed("收藏失败");
                }
            } else if (collectInfo.getStatus() == CollectStatus.COLLECT.getCode()) {
                collectInfo.setStatus(CollectStatus.CANCEL_COLLECT.getCode());
                if (collectInfoService.update(collectInfo)) {
                    return success(convert(collectInfo));
                } else {
                    return failed("取消收藏失败");
                }
            }
        }
        if (collectInfoService.save(convert(collectInfoVO))) {
            CollectInfo collectInfo1 = collectInfoService.getCollectInfo(collectInfoVO.getUserId(), collectInfoVO.getCollect(), collectInfoVO.getCollectType());
            return success(convert(collectInfo1));
        }
        return failed("收藏失败");
    }

    @RequestMapping(value = "getCollectProduction", method = RequestMethod.GET)
    @ApiOperation(value = "获取作品收藏列表")
    public ApiResponse<CollectInfoVO> getCollectProduction(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        CollectInfoVO result = new CollectInfoVO();
        Long userId = Context.getCurrUserId();
        List<Long> productionId = collectInfoService.getProductionId(userId);
        Page<ProductionInfo> productionInfo = productionInfoService.getPageProductionById(productionId, currentPage, pageSize);
        if (CollectionUtils.isEmpty(productionInfo.getData())) {
            return success(result);
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

    @RequestMapping(value = "getCollectDemand", method = RequestMethod.GET)
    @ApiOperation(value = "获取需求收藏列表")
    public ApiResponse<CollectInfoVO> getCollectDemand(@RequestParam("currentPage") Integer currentPage,
                                                       @RequestParam("pageSize") Integer pageSize,
                                                       @RequestParam("status") Integer status) {
        CollectInfoVO result = new CollectInfoVO();
        Map<String, Integer> map = new HashMap<>();
        Integer closed;
        Integer opened;
        Long userId = Context.getCurrUserId();
        List<Long> demandId = collectInfoService.getDemandId(userId);
        if (CollectionUtils.isEmpty(demandId)) {
            map.put("total", 0);
            map.put("opened", 0);
            map.put("closed", 0);
            result.setDemandInfoCount(map);
            return success(result);
        }
        Page<DemandInfo> pageDemandInfo = demandInfoService.getPageDemandInfo(demandId, currentPage, pageSize,status);
        if (CollectionUtils.isEmpty(pageDemandInfo.getData())) {
            opened = demandInfoService.getOpenedDemandCount(demandId);
            closed = demandInfoService.getDemandClosedCount(demandId);
            map.put("total", opened + closed);
            map.put("opened", opened);
            map.put("closed", closed);
            result.setDemandInfoCount(map);
            return success(result);
        }
        opened = demandInfoService.getOpenedDemandCount(demandId);
        closed = demandInfoService.getDemandClosedCount(demandId);
        map.put("total", opened + closed);
        map.put("opened", opened);
        map.put("closed", closed);
        List<DemandInfoVO> data = pageDemandInfo.getData().stream().map(demandInfoMapper::toDemandInfoVO).collect(Collectors.toList());
        Map<Long, BdJobCate> bdJobCateMap = data.stream().map(DemandInfoVO::getJobCateId).collect(Collectors.toList())
                .stream().map(jobCateId -> iBdJobCateService.get(jobCateId)).collect(Collectors.toList())
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));
        data.forEach(demandInfoVO -> {
            if (bdJobCateMap.containsKey(demandInfoVO.getJobCateId())) {
                demandInfoVO.setJobCateIdName(bdJobCateMap.get(demandInfoVO.getJobCateId()).getCateName());
            }
        });
        PageInfo<DemandInfoVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(pageDemandInfo.getTotal());
        pageInfo.setData(data);
        result.setDemandInfo(pageInfo);
        result.setDemandInfoCount(map);
        return success(result);
    }

    @Override
    protected Service<CollectInfo> service() {
        return collectInfoService;
    }
}
