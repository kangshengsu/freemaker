/**
 * @filename:DemandProductionRelationDao 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.business.base.model.demand.DemandProductionRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:(需求作品关系数据访问层)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Mapper
public interface IDemandProductionRelationMapper extends BaseMapper<DemandProductionRelation> {

}
