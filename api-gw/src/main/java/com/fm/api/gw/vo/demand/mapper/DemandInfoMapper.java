package com.fm.api.gw.vo.demand.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.business.base.model.demand.DemandInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class DemandInfoMapper extends CommonMapper {

    @Mappings({
            @Mapping(target = "employerInfo.name", source = "employerInfo.name"),
            @Mapping(target = "employerInfo.headImg", source = "employerInfo.headImg",qualifiedByName = "fullHeadImgPath"),
            @Mapping(target = "employerInfo.phone", source = "employerInfo.phone"),
            @Mapping(target = "jobTitle", source = "employerInfo.jobTitle"),
            @Mapping(target = "demandStatus",source = "demandStatus")
    })
    public abstract DemandInfoVO toDemandInfoVO(DemandInfo demandInfo);

}
