package com.fm.api.gw.vo.rotation.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.rotation.RotationInfoVO;
import com.fm.business.base.model.rotation.RotationInfo;
import org.mapstruct.Mapper;

/**
 * @author G
 * @date 2020/12/25 下午4:14
 */
@Mapper(componentModel = "spring")
public abstract class RotationMapper extends CommonMapper {

    public abstract RotationInfoVO toRotationVO(RotationInfo rotationInfo);
}
