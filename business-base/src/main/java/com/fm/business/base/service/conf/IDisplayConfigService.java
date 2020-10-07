package com.fm.business.base.service.conf;

import com.fm.business.base.model.conf.DisplayConfig;
import com.fm.business.base.model.conf.DisplayType;
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

    /**
     * 根据展示类型获取展现配置
     * @param displayType 展现类型
     * @return 展现配置的集合
     */
    List<DisplayConfig> get(DisplayType displayType);

    /**
     * 是否存在某个配置类型下的配置项信息
     * @param displayId 展现项信息
     * @param displayType 展现类型
     * @return 是否存在
     */
    boolean exist(Long displayId, DisplayType displayType);


    /**
     * 某个配置类型下的配置项信息个数
     * @param displayId 展现项信息
     * @param displayType 展现类型
     * @return 是否存在
     */
    int count(Long displayId, DisplayType displayType);

}
