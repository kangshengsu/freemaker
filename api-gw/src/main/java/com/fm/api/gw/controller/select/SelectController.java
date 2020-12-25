package com.fm.api.gw.controller.select;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.demand.mapper.DemandInfoMapper;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.api.gw.vo.select.SelectVO;
import com.fm.business.base.enums.CollectType;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.select.SelectInfo;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.select.ISelectInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/23 16:21
 */
@RestController
@RequestMapping("/v1/select")
@Api(description = "搜索接口")
public class SelectController extends BaseController<SelectInfo, SelectVO> {


    @Autowired
    private ISelectInfoService selectInfoService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private DemandInfoMapper demandInfoMapper;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @RequestMapping(value = "insertKeyword", method = RequestMethod.POST)
    @ApiOperation("保存搜索关键词")
    public ApiResponse<Boolean> insertKeyWord(@Valid @RequestBody SelectVO selectVO, HttpServletRequest request) {
        Boolean isNeedValid = Boolean.valueOf(request.getHeader("isNeedValid"));
        if (isNeedValid) {
            Long userId = Context.getCurrUserId();
            if (ObjectUtil.isNotNull(userId)) {
                selectVO.setUserId(userId);
                SelectInfo selectInfo = selectInfoService.selectByUserIdAndKeyword(userId, selectVO.getKeyword());
                if (ObjectUtil.isNotNull(selectInfo)) {
                    return success(selectInfoService.update(selectInfo));
                }
                return success(selectInfoService.save(convert(selectVO)));
            }
        }
        return ApiResponse.ofSuccess(Boolean.FALSE);
    }

    @RequestMapping(value = "getSelectRecords", method = RequestMethod.GET)
    @ApiOperation("查询用户搜索记录")
    public ApiResponse<Map<String, List<String>>> getSelectRecords(HttpServletRequest request) {
        Boolean isNeedValid = Boolean.valueOf(request.getHeader("isNeedValid"));
        if (isNeedValid) {
            Long userId = Context.getCurrUserId();
            if (ObjectUtil.isNotNull(userId)) {
                return success(selectInfoService.getKeyWordsByUserId(userId));
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        return success(map);
    }

    @RequestMapping(value = "getPageSelect", method = RequestMethod.GET)
    @ApiOperation("按关键词查询作品及需求")
    public ApiResponse<SelectVO> getPageSelect(@RequestParam("keyword") String keyword,
                                               @RequestParam("currentPage") Integer currentPage,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("moreStatus") Integer moreStatus) {
        SelectVO result = new SelectVO();
        if (moreStatus == CollectType.PRODUCTION.getCode()) {
            PageInfo<ProductionViewVO> pageInfo = getProductionViewVOPageInfo(keyword, currentPage, pageSize);
            result.setProductionViewVO(pageInfo);
            return success(result);
        } else if (moreStatus == CollectType.DEMAND.getCode()) {
            PageInfo<DemandInfoVO> demandPageInfo = getDemandInfoVOPageInfo(keyword, currentPage, pageSize);
            result.setDemandInfoVO(demandPageInfo);
            return success(result);
        }
        PageInfo<ProductionViewVO> pageInfo = getProductionViewVOPageInfo(keyword, currentPage, pageSize);
        PageInfo<DemandInfoVO> demandPageInfo = getDemandInfoVOPageInfo(keyword, currentPage, pageSize);
        result.setProductionViewVO(pageInfo);
        result.setDemandInfoVO(demandPageInfo);
        return success(result);
    }

    @RequestMapping(value = "deleteKeyword", method = RequestMethod.GET)
    @ApiOperation("清空关键词搜索记录")
    public ApiResponse<Boolean> deleteKeyword() {
        Long userId = Context.getCurrUserId();
        if (ObjectUtil.isNotNull(userId)) {
            return success(selectInfoService.deleteKeyword(userId));
        }
        return success(Boolean.FALSE);
    }


    private PageInfo<DemandInfoVO> getDemandInfoVOPageInfo(@RequestParam("keyword") String keyword, @RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        Page<DemandInfo> demandInfoPage = demandInfoService.getDemandByKeyword(keyword, currentPage, pageSize);
        List<DemandInfoVO> demandInfoVOList = demandInfoPage.getData().stream().map(demandInfoMapper::toDemandInfoVO).collect(Collectors.toList());
        Map<Long, BdJobCate> bdJobCateMap = demandInfoVOList.stream().map(DemandInfoVO::getJobCateId).collect(Collectors.toList())
                .stream().map(jobCateId -> iBdJobCateService.get(jobCateId)).collect(Collectors.toList())
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));
        demandInfoVOList.forEach(demandInfoVO -> {
            if (bdJobCateMap.containsKey(demandInfoVO.getJobCateId())) {
                demandInfoVO.setJobCateIdName(bdJobCateMap.get(demandInfoVO.getJobCateId()).getCateName());
            }
        });
        PageInfo<DemandInfoVO> demandPageInfo = new PageInfo<>();
        demandPageInfo.setCurrentPage(currentPage);
        demandPageInfo.setPageSize(pageSize);
        demandPageInfo.setTotal(demandInfoPage.getTotal());
        demandPageInfo.setData(demandInfoVOList);
        return demandPageInfo;
    }

    private PageInfo<ProductionViewVO> getProductionViewVOPageInfo(@RequestParam("keyword") String keyword, @RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        Page<ProductionInfo> productionInfoPage = productionInfoService.getProductionInfoByKeyword(keyword, currentPage, pageSize);
        List<ProductionViewVO> data = productionInfoPage.getData().stream().map(productionMapper::toProductionViewVO).collect(Collectors.toList());
        PageInfo<ProductionViewVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(productionInfoPage.getTotal());
        pageInfo.setData(data);
        return pageInfo;
    }

    @RequestMapping(value = "getRecommendKeywords", method = RequestMethod.GET)
    @ApiOperation("获取推荐关键词")
    public ApiResponse<List<SelectVO>> getRecommendKeywords() {
        return success(convert(selectInfoService.getRecommendKeywordsByWeight()));
    }


    @Override
    protected Service<SelectInfo> service() {
        return selectInfoService;
    }
}
