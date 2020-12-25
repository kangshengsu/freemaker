package com.fm.api.gw.vo.advert.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.advert.AdvertInfoVO;
import com.fm.business.base.model.advert.AdvertInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author G
 * @date 2020/12/25 上午11:10
 */
@Mapper(componentModel = "spring")
public abstract class AdvertInfoMapper extends CommonMapper {

    @Mapping(target = "path", source = "path", qualifiedByName = "fullHeadImgPath")
    public abstract AdvertInfoVO toAdvertVO(AdvertInfo advertInfo);

}
