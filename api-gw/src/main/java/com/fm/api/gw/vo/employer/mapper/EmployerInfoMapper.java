package com.fm.api.gw.vo.employer.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.business.base.model.EmployerInfo;
import com.fm.framework.core.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public abstract class EmployerInfoMapper extends CommonMapper {

    @Mapping(target = "headImg", source = "headImg",qualifiedByName = "fullHeadImgPath")
    public abstract EmployerInfoApiVO toEmployerInfoApi(EmployerInfo employerInfo);


}
