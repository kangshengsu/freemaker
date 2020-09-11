/**
 * @filename:BdJobSkillDao 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.fm.framework.core.model.BdJobSkill;

/**   
 * @Description:(岗位技能数据访问层)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Mapper
public interface IBdJobSkillMapper extends BaseMapper<BdJobSkill> {
	
}
