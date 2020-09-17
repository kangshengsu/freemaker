/**
 * @filename:SysBaseDictDao 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.fm.business.base.model.sys.SysBaseDict;

/**   
 * @Description:(基础字典数据访问层)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Mapper
public interface ISysBaseDictMapper extends BaseMapper<SysBaseDict> {
	
}
