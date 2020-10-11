package com.fm.api.gw.vo.freelancer.mapper;

import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FreelancerInfoMapper {
    public abstract FreelancerInfoApiVO toFreelancerInfoApi(FreelancerInfo freelancerInfo);
}
