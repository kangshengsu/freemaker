package com.fm.api.web.vo.sm.mapper;

import com.fm.api.web.vo.sm.OrgVO;
import com.fm.business.base.model.sm.Org;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <p>组织Mapper</p>
 *
 * @author hubo
 */
@Mapper
public interface OrgMapper {

    OrgMapper INSTANCE = Mappers.getMapper(OrgMapper.class);

    @Mapping(target = "parentName", ignore = true)
    @Mapping(target = "hasChildren", ignore = true)
    @Mapping(target = "children", ignore = true)
    OrgVO toOrgVO(Org org);


    @Mapping(target = "updateUser", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "isDelete", ignore = true)
    @Mapping(target = "createUser", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Org to(OrgVO orgVO);

}
