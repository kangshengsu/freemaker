/**
 * @filename:ProductionInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production;

import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Description:(作品服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IProductionInfoService extends Service<ProductionInfo> {

    /**
     * 根据作品编码获取作品信息
     * @param codes 作品编码集合
     * @return 作品信息
     */
    List<ProductionInfo> get(Collection<String> codes);
	
}