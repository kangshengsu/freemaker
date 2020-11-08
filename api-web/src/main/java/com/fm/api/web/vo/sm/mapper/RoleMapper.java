package com.fm.api.web.vo.sm.mapper;

import com.jd.labbed.core.sm.model.Role;
import com.jd.labbed.mvc.tenant.vo.RoleVO;
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


    @Mapping(target = "isDelete", ignore = true)
    Role toRole(RoleVO roleVO);

}
