package com.fm.business.base.service.conf.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.conf.DisplayConfigMapper;
import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.conf.DisplayType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.conf.IDisplayConfigService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 展现配置接口
 *
 * @author hubo
 * @version 1.0.0
 **/
@Slf4j
@Service
public class DisplayConfigServiceImpl extends AuditBaseService<DisplayConfigMapper, DisplayConfig> implements IDisplayConfigService {

    /**
     * 领域、岗位服务
     */
    private final IBdJobCateService bdJobCateService;

    /**
     * 产品信息服务
     */
    private final IProductionInfoService productionInfoService;

    @Autowired
    public DisplayConfigServiceImpl(IBdJobCateService bdJobCateService, IProductionInfoService productionInfoService) {
        this.bdJobCateService = bdJobCateService;
        this.productionInfoService = productionInfoService;
    }

    @Override
    @Cacheable(value = "firstLevelJobCateConfig")
    public List<BdJobCate> getFirstLevelJobCateConfig() {
        return getJobCate(get(DisplayType.job_cate_1));
    }

    @Override
    @Cacheable(value = "secondLevelJobCateConfig")
    public List<BdJobCate> getSecondLevelJobCateConfig() {
        return getJobCate(get(DisplayType.job_cate_2));
    }

    @Override
    @Cacheable(value = "recommendProductInfoConfig")
    public List<ProductionInfo> getRecommendProductInfoConfig() {
        return getProductInfo(get(DisplayType.r_product_info));
    }

    /**
     * 更加展现配置获取领域、岗位
     * @param displayConfigs 展现配置集合
     * @return 领域、岗位集合
     */
    public List<BdJobCate> getJobCate(Collection<DisplayConfig> displayConfigs) {

        if (displayConfigs.isEmpty()) {
            return Collections.emptyList();
        }

        log.info("getJobCate displayConfigs: {}", displayConfigs);

        Set<Long> jobCateIds = displayConfigs
                .stream()
                .map(DisplayConfig::getDisplayId)
                .collect(Collectors.toSet());

        return bdJobCateService.getByIds(jobCateIds);

    }

    /**
     * 更加展现配置获取领域、岗位
     * @param displayConfigs 展现配置集合
     * @return 领域、岗位集合
     */
    public List<ProductionInfo> getProductInfo(Collection<DisplayConfig> displayConfigs) {

        if (displayConfigs.isEmpty()) {
            return Collections.emptyList();
        }

        log.info("getProductInfo displayConfigs: {}", displayConfigs);


        Set<Long> jobProductIds = displayConfigs
                .stream()
                .map(DisplayConfig::getDisplayId)
                .collect(Collectors.toSet());

        return productionInfoService.getFullInfo(jobProductIds);

    }

    /**
     * 根据展现类型获取展现配置项
     *
     * @param displayType 展现类型
     * @return 展现信息项
     */
    public List<DisplayConfig> get(DisplayType displayType) {

        if (Objects.isNull(displayType) || displayType.getCode() <= 0) {
            return Collections.emptyList();
        }

        return this.list(Wrappers.lambdaQuery(DisplayConfig.class)
                .eq(DisplayConfig::getDisplayType, displayType.getCode())
                .ge(DisplayConfig::getExpiredTime, new Date()));
    }
}
