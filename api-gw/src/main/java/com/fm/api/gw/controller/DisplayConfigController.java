package com.fm.api.gw.controller;

import com.fm.api.gw.mapper.conf.DisplayMapper;
import com.fm.api.gw.vo.conf.AggDisplayConfigVO;
import com.fm.api.gw.vo.conf.DisplayConfigVO;
import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.conf.IDisplayConfigService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.VO;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页展示配置Controller
 *
 * @author clufeng
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/v1/display")
public class DisplayConfigController extends BaseController<DisplayConfig, DisplayConfigVO> {

    private final IDisplayConfigService displayConfigService;

    @Autowired
    private DisplayMapper displayMapper;

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    public DisplayConfigController(IDisplayConfigService displayConfigService) {
        this.displayConfigService = displayConfigService;
    }

    @RequestMapping("/configs")
    @ApiOperation(value = "获取展示配置操作", httpMethod = "GET")
    public ApiResponse<AggDisplayConfigVO> getAllDisplayConfig(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize) {

        AggDisplayConfigVO result = new AggDisplayConfigVO();
//
//        result.setFirstLevelJobs(displayConfigService.getFirstLevelJobCateConfig()
//                .stream().map(displayMapper::toJobCateDisplayVO).collect(Collectors.toList()));
//
//        result.setSecondLevelJobs(displayConfigService.getSecondLevelJobCateConfig().
//                stream().map(displayMapper::toJobCateDisplayVO).collect(Collectors.toList()));

        if (currentPage == 1) {
            result.setRecommendProductInfos(displayConfigService.getRecommendProductInfoConfig()
                    .stream().map(productionMapper::toProductionListVO).collect(Collectors.toList()));
        }
        Page<ProductionInfo> productionInfoPage = productionInfoService.getPageProductionOrderByWeight(currentPage, pageSize);
        List<ProductionListVO> list = productionInfoPage.getData().stream().map(productionMapper::toProductionListVO).collect(Collectors.toList());
        PageInfo<ProductionListVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(productionInfoPage.getCurrentPage());
        pageInfo.setPageSize(productionInfoPage.getPageSize());
        pageInfo.setTotal(productionInfoPage.getTotal());
        pageInfo.setData(list);
        result.setProductionListInfo(pageInfo);

        return ApiResponse.ofSuccess(result);

    }

    @Override
    protected Service<DisplayConfig> service() {
        return displayConfigService;
    }

//    private Page<ProductionListVO> convertProductionPage(Page<ProductionInfo> productionInfoPage) {
//        PageInfo<ProductionListVO> pageInfo = new PageInfo<>();
//        pageInfo.setCurrentPage(productionInfoPage.getCurrentPage());
//        pageInfo.setPageSize(productionInfoPage.getPageSize());
//        pageInfo.setTotal(productionInfoPage.getTotal());
//        if (CollectionUtils.isEmpty(productionInfoPage.getData())) {
//            pageInfo.setData(productionInfoPage.getData().stream().map(this::convertProductionListVo).collect(Collectors.toList()));
//        }
//        return pageInfo;
//    }
//
//    private ProductionListVO convertProductionListVo(ProductionInfo productionInfo) {
//        ProductionListVO productionListVO = new ProductionListVO();
//        BeanUtils.copyProperties(productionInfo, productionListVO);
//        return productionListVO;
//    }

}
