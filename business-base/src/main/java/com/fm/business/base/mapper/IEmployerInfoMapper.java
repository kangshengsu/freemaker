/**
 * @filename:EmployerInfoDao 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.business.base.model.EmployerInfo;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Description:(雇佣者信息数据访问层)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Mapper
public interface IEmployerInfoMapper extends BaseMapper<EmployerInfo> {
	
}
