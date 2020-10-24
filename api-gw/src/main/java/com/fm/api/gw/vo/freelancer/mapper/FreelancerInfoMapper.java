package com.fm.api.gw.vo.freelancer.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public abstract class FreelancerInfoMapper extends CommonMapper {

    @Mapping(target = "headImg", source = "headImg",qualifiedByName = "fullHeadImgPath")
    public abstract FreelancerInfoApiVO toFreelancerInfoApi(FreelancerInfo freelancerInfo);


}
