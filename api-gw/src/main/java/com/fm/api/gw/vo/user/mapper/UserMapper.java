package com.fm.api.gw.vo.user.mapper;

import com.fm.api.gw.vo.user.UserApiVO;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.sys.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/**
 * @program: freemaker-parent
 * @description: 用户实体转换映射器
 * @author: liuduo8
 * @create: 2020-10-17 11:04
 **/
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "avatarUrl", source = "headImg"),

            @Mapping(target = "freelancerInfo.provinceCode", source = "provinceCode"),
            @Mapping(target = "freelancerInfo.cityCode", source = "cityCode"),
            @Mapping(target = "freelancerInfo.districtCode", source = "districtCode"),
            @Mapping(target = "freelancerInfo.countyCode", source = "countyCode"),
            @Mapping(target = "freelancerInfo.name", source = "name"),
            @Mapping(target = "freelancerInfo.headImg", source = "headImg"),
            @Mapping(target = "freelancerInfo.skillSummarize", source = "freelancerInfo.skillSummarize"),
            @Mapping(target = "freelancerInfo.language", source = "freelancerInfo.language"),

            @Mapping(target = "employerInfo.provinceCode", source = "provinceCode"),
            @Mapping(target = "employerInfo.cityCode", source = "cityCode"),
            @Mapping(target = "employerInfo.districtCode", source = "districtCode"),
            @Mapping(target = "employerInfo.countyCode", source = "countyCode"),
            @Mapping(target = "employerInfo.name", source = "name"),
            @Mapping(target = "employerInfo.headImg", source = "headImg")
    })
    SysUser toSysUser(UserApiVO userApiVO);

    @Mappings({
            @Mapping(source = "avatarUrl", target = "headImg"),
            @Mapping(source = "freelancerInfo.provinceCode", target = "provinceCode"),
            @Mapping(source = "freelancerInfo.cityCode", target = "cityCode"),
            @Mapping(source = "freelancerInfo.districtCode", target = "districtCode"),
            @Mapping(source = "freelancerInfo.countyCode", target = "countyCode"),
            @Mapping(source = "freelancerInfo.name", target = "name"),
            @Mapping(source = "freelancerInfo.skillSummarize", target = "freelancerInfo.skillSummarize"),
            @Mapping(source = "freelancerInfo.language", target = "freelancerInfo.language"),
    })
    UserApiVO toUserApiVO(SysUser sysUser);

}
