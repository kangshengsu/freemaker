package com.fm.api.gw.vo.employer.mapper;

import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.business.base.model.EmployerInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmployerInfoMapper {
    public abstract EmployerInfoApiVO toEmployerInfoApi(EmployerInfo employerInfo);

}
