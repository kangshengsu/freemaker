/**
 * @filename:SysBaseDictServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.sys.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.constant.BaseDictGroupConstants;
import com.fm.business.base.model.sys.SysBaseDict;
import com.fm.business.base.dao.sys.ISysBaseDictMapper;
import com.fm.business.base.service.sys.ISysBaseDictService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**   
 * @Description:(基础字典服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("sysBaseDictService")
public class SysBaseDictServiceImpl extends BaseService<ISysBaseDictMapper, SysBaseDict> implements ISysBaseDictService  {

    /**
     * 根据所属分组获取字典数据
     * @param group
     * @return
     */
    @Override
    public List<SysBaseDict> findByBelongGroup(BaseDictGroupConstants group) {
        if(group == null){
            return Collections.EMPTY_LIST;
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(SysBaseDict.class).eq(SysBaseDict::getBelongGroup,group.getGroup())
                .orderByAsc(SysBaseDict::getNodeLevel,SysBaseDict::getOrderNum));
    }
}