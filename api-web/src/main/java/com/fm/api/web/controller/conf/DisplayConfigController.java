package com.fm.api.web.controller.conf;

import com.fm.api.web.convert.DisplayConfigConvert;
import com.fm.api.web.vo.conf.DisplayConfigVO;
import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.conf.DisplayConfigItem;
import com.fm.business.base.model.conf.DisplayType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.conf.IDisplayConfigService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hubo
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/display")
public class DisplayConfigController extends BaseController<DisplayConfig, DisplayConfigVO> {

    @Autowired
    private IDisplayConfigService displayConfigService;

    @Override
    protected Service<DisplayConfig> service() {
        return displayConfigService;
    }

    @RequestMapping("/configs")
    public ApiResponse<List<DisplayConfigVO>> getDisplayConfigs(int type) {

        DisplayType displayType = DisplayType.resolver(type);

        List<DisplayConfig> displayConfigList = displayConfigService.get(displayType);

        List<DisplayConfigVO> result = convert(displayType, displayConfigList);

        return ApiResponse.ofSuccess(result);
    }

    @RequestMapping("/config/items")
    public ApiResponse<List<DisplayConfigItem>> getDisplayConfigItems(int type, @RequestParam(required = false) String query) {

        DisplayType displayType = DisplayType.resolver(type);
        List<DisplayConfigItem> displayConfigList;
        if(StringUtils.isEmpty(query)) {
            displayConfigList = displayConfigService.getDisplayConfigItem(displayType);

        }else {
            displayConfigList = displayConfigService.getDisplayConfigItem(query, displayType);

        }


        return ApiResponse.ofSuccess(displayConfigList);
    }

    @RequestMapping("/config/item")
    public ApiResponse<DisplayConfigItem> getDisplayConfigItems(Long displayId, int type) {

        DisplayType displayType = DisplayType.resolver(type);
        DisplayConfigItem displayConfig = displayConfigService.getDisplayConfigItem(displayId, displayType);
        return ApiResponse.ofSuccess(displayConfig);
    }

    @RequestMapping("/config/count")
    public ApiResponse<Integer> exist(long displayId, int type) {

        DisplayType displayType = DisplayType.resolver(type);

        int count = displayConfigService.count(displayId, displayType);

        return ApiResponse.ofSuccess(count);
    }

    @RequestMapping(value = "/config",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody DisplayConfigVO form) {
        return super.create(form);
    }

    @RequestMapping(value = "/config",method = RequestMethod.PUT)
    public ApiResponse<Boolean> modify(@RequestBody DisplayConfigVO form) {
        return super.update(form);
    }

    @RequestMapping(value = "/config",method = RequestMethod.DELETE)
    public ApiResponse<Boolean> delete(Long id) {
        return super.delete(id);
    }

    @RequestMapping(value = "isShowIM",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateIsShowIM(@RequestBody DisplayConfigVO form){
        List<DisplayConfig> displayConfigs = displayConfigService.get(DisplayType.IM);
        DisplayConfig displayConfig = displayConfigs.get(0);
        if (displayConfig != null) {
            if (form.getIsShowIm() == true) {
                displayConfig.setIsShowIm(1);
            }else{
                displayConfig.setIsShowIm(0);
            }
           return success(displayConfigService.update(displayConfig));
        }
        return failed("修改失败");
    }


    protected List<DisplayConfigVO> convert(DisplayType displayType, List<DisplayConfig> modes) {
        switch (displayType) {
            case job_cate_1:
                Map<Long, BdJobCate> bdJobMap1 = displayConfigService.getFirstLevelJobCateConfigNoCache()
                        .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));
                return modes.stream().map(displayConfig -> {
                    DisplayConfigVO configVO = DisplayConfigConvert.INSTANCE.to(displayConfig);
                    if(bdJobMap1.containsKey(configVO.getDisplayId())) {
                        configVO.setResourceName(bdJobMap1.get(configVO.getDisplayId()).getCateName());
                    }
                    return configVO;
                }).collect(Collectors.toList());
            case job_cate_2:
                Map<Long, BdJobCate> bdJobMap2 = displayConfigService.getSecondLevelJobCateConfigNoCache()
                        .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));
                return modes.stream().map(displayConfig -> {
                    DisplayConfigVO configVO = DisplayConfigConvert.INSTANCE.to(displayConfig);
                    if(bdJobMap2.containsKey(configVO.getDisplayId())) {
                        configVO.setResourceName(bdJobMap2.get(configVO.getDisplayId()).getCateName());
                    }
                    return configVO;
                }).collect(Collectors.toList());
            case r_product_info:
                Map<Long, ProductionInfo> productionInfoMap = displayConfigService.getRecommendProductInfoConfigNoCache().stream()
                        .collect(Collectors.toMap(ProductionInfo::getId, Function.identity(), (v1, v2) -> v2));

                return modes.stream().map(displayConfig -> {
                    DisplayConfigVO configVO = DisplayConfigConvert.INSTANCE.to(displayConfig);
                    if(productionInfoMap.containsKey(configVO.getDisplayId())) {
                        configVO.setResourceName(productionInfoMap.get(configVO.getDisplayId()).getTitle());
                    }
                    return configVO;
                }).collect(Collectors.toList());

        }

        return Collections.emptyList();
    }


}
