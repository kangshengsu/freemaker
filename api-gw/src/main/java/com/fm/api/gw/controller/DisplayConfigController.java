package com.fm.api.gw.controller;

import com.fm.api.gw.vo.conf.AggDisplayConfigVO;
import com.fm.business.base.service.conf.IDisplayConfigService;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页展示配置Controller
 * @author hubo
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/api/v1/display")
public class DisplayConfigController  {

    private final IDisplayConfigService displayConfigService;

    @Autowired
    public DisplayConfigController(IDisplayConfigService displayConfigService) {
        this.displayConfigService = displayConfigService;
    }

    @RequestMapping("/configs")
    @ApiOperation(value = "获取展示配置操作", httpMethod = "GET")
    public ApiResponse<AggDisplayConfigVO> getAllDisplayConfig() {

        AggDisplayConfigVO result = new AggDisplayConfigVO();

        result.setFirstLevelJobs(displayConfigService.getFirstLevelJobCateConfig());

        result.setSecondLevelJobs(displayConfigService.getSecondLevelJobCateConfig());

        result.setRecommendProductInfos(displayConfigService.getRecommendProductInfoConfig());

        return ApiResponse.ofSuccess(result);

    }

}
