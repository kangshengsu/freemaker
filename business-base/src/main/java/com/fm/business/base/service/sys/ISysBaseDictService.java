/**
 * @filename:SysBaseDictService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.sys;

import com.fm.business.base.constant.BaseDictGroupConstants;
import com.fm.business.base.model.sys.SysBaseDict;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(基础字典服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface ISysBaseDictService extends Service<SysBaseDict> {

    /**
     * 根据所属分组获取字典数据
     * @param group
     * @return
     */
    List<SysBaseDict> findByBelongGroup(BaseDictGroupConstants group);

}