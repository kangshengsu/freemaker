package com.fm.api.gw.controller;

import com.fm.api.gw.mapper.conf.DisplayMapper;
import com.fm.api.gw.vo.conf.AggDisplayConfigVO;
import com.fm.api.gw.vo.conf.DisplayConfigVO;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.service.conf.IDisplayConfigService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public DisplayConfigController(IDisplayConfigService displayConfigService) {
        this.displayConfigService = displayConfigService;
    }

    @RequestMapping("/configs")
    @ApiOperation(value = "获取展示配置操作", httpMethod = "GET")
    public ApiResponse<AggDisplayConfigVO> getAllDisplayConfig() {

        AggDisplayConfigVO result = new AggDisplayConfigVO();

        result.setFirstLevelJobs(displayConfigService.getFirstLevelJobCateConfig()
                .stream().map(displayMapper::toJobCateDisplayVO).collect(Collectors.toList()));

        result.setSecondLevelJobs(displayConfigService.getSecondLevelJobCateConfig().
                stream().map(displayMapper::toJobCateDisplayVO).collect(Collectors.toList()));

        result.setRecommendProductInfos(displayConfigService.getRecommendProductInfoConfig()
                .stream().map(productionMapper::toProductionListVO).collect(Collectors.toList()));

        return ApiResponse.ofSuccess(result);

    }

    @Override
    protected Service<DisplayConfig> service() {
        return displayConfigService;
    }


}
