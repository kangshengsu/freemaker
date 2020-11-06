package com.fm.business.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.business.base.model.demand.DemandInfo;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface IDemandCenterInfoMapper extends BaseMapper<DemandInfo> {

}