package com.fm.api.web.vo.sm.mapper;

import com.fm.api.web.vo.sm.RoleVO;
import com.fm.business.base.model.sm.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


    @Mapping(target = "updateUser", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "isDelete", ignore = true)
    Role toRole(RoleVO roleVO);

    @Mapping(target = "users", ignore = true)
    @Mapping(target = "menus", ignore = true)
    RoleVO toRoleVO(Role role);

}
