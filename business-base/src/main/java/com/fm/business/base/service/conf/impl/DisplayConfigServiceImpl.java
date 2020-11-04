package com.fm.business.base.service.conf.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.conf.DisplayConfigMapper;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.conf.DisplayConfigItem;
import com.fm.business.base.model.conf.DisplayConfigItemConvert;
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
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisTemplate redisTemplate;


    @Autowired
    public DisplayConfigServiceImpl(IBdJobCateService bdJobCateService, IProductionInfoService productionInfoService) {
        this.bdJobCateService = bdJobCateService;
        this.productionInfoService = productionInfoService;
    }

    @Override
    @Cacheable(value = "firstLevelJobCateConfig")
    public List<BdJobCate> getFirstLevelJobCateConfig() {
        return getFirstLevelJobCateConfigNoCache();
    }

    @Override
    public List<BdJobCate> getFirstLevelJobCateConfigNoCache() {
        return getJobCate(get(DisplayType.job_cate_1));
    }

    @Override
    @Cacheable(value = "secondLevelJobCateConfig")
    public List<BdJobCate> getSecondLevelJobCateConfig() {
        return getSecondLevelJobCateConfigNoCache();
    }

    @Override
    public List<BdJobCate> getSecondLevelJobCateConfigNoCache() {
        return getJobCate(get(DisplayType.job_cate_2));
    }

    @Override
    @Cacheable(value = "recommendProductInfoConfig")
    public List<ProductionInfo> getRecommendProductInfoConfig() {
        return getRecommendProductInfoConfigNoCache();
    }

    @Override
    public List<ProductionInfo> getRecommendProductInfoConfigNoCache() {
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
        String displayKey = getDisplayConfigsKey();
        List<BdJobCate> bdJobCateList = redisTemplate.opsForHash().values(displayKey);
        HashMap<String, BdJobCate> map = new HashMap<>();
        if(bdJobCateList.isEmpty()){
            List<BdJobCate> jobCateList = bdJobCateService.getByIds(jobCateIds);
            if (!jobCateList.isEmpty()){
                for (BdJobCate bdJobCate : jobCateList) {
                    map.put(bdJobCate.getId().toString(), bdJobCate);
                }
                redisTemplate.opsForHash().putAll(displayKey, map);
            }
            return jobCateList;
        }
        return bdJobCateList;
    }

    private String getDisplayConfigsKey(){
        String displayKey = "displayConfigs";
        return displayKey;
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

        return productionInfoService.getFullInfo(jobProductIds, ProductionStatus.RELEASE);

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
                .eq(DisplayConfig::getDisplayType, displayType.getCode()));
//                .ge(DisplayConfig::getExpiredTime, new Date()));
    }

    @Override
    public boolean exist(Long displayId, DisplayType displayType) {
        return count(displayId, displayType) > 0;
    }

    @Override
    public int count(Long displayId, DisplayType displayType) {

        if (Objects.isNull(displayId) || Objects.isNull(displayType) || displayType.getCode() <= 0) {
            return 0;
        }

        return this.count(Wrappers.lambdaQuery(DisplayConfig.class)
                .eq(DisplayConfig::getDisplayType, displayType.getCode())
                .eq(DisplayConfig::getDisplayId, displayId));

    }

    @Override
    public List<DisplayConfigItem> getDisplayConfigItem(DisplayType displayType) {

        switch (displayType) {
            case job_cate_1:
                List<BdJobCate> domainJobCateList = bdJobCateService.findJobCateDomain(null);
                return domainJobCateList.stream().map(DisplayConfigItemConvert.INSTANCE::to).collect(Collectors.toList());
            case job_cate_2:
                List<BdJobCate> postJobCateList = bdJobCateService.findAllJobCatePost();
                return postJobCateList.stream().map(DisplayConfigItemConvert.INSTANCE::to).collect(Collectors.toList());

        }

        return null;
    }

    @Override
    public List<DisplayConfigItem> getDisplayConfigItem(String title, DisplayType displayType) {
        if (displayType == DisplayType.r_product_info) {
            return productionInfoService.query(title).stream().map(DisplayConfigItemConvert.INSTANCE::to).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public DisplayConfigItem getDisplayConfigItem(Long displayId, DisplayType displayType) {

        if (displayType == DisplayType.r_product_info) {
            return DisplayConfigItemConvert.INSTANCE.to(productionInfoService.get(displayId));
        }

        return null;
    }
}
