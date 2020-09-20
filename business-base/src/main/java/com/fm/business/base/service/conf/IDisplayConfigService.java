package com.fm.business.base.service.conf;

import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * 展现配置服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IDisplayConfigService extends Service<DisplayConfig> {

    /**
     * 获取领域（一级分类）展现配置信息
     * @return 领域配置信息列表
     */
    List<BdJobCate> getFirstLevelJobCateConfig();


    /**
     * 获取岗位（二级分类）展现配置信息
     * @return 岗位配置信息列表
     */
    List<BdJobCate> getSecondLevelJobCateConfig();


    /**
     * 获取推荐产品配置信息
     * @return 配置的产品信息
     */
    List<ProductionInfo> getRecommendProductInfoConfig();

}
