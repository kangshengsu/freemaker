package com.fm.api.gw.vo.production.mapper;

import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * liuduo
 * <p>
 * 作品相关映射
 */
@Mapper(componentModel = "spring")
public interface ProductionMapper {

    @Mapping(target = "images", source = "attachmentInfos")
    @Mapping(target = "statusName", expression = "java(com.fm.business.base.enums.ProductionStatus.get(productionInfo.getStatus()).getName())")
    ProductionListVO toProductionListVO(ProductionInfo productionInfo);

    @Mappings({
            @Mapping(target = "images", source = "attachmentInfos"),
            @Mapping(target = "statusName", source = "status"),
            @Mapping(target = "skills", source = "productionSkillRelations")
    })
    ProductionViewVO toProductionViewVO(ProductionInfo productionInfo);

    default String statusConvert(Integer status) {
        if (ProductionStatus.get(status) != null) {
            return ProductionStatus.get(status).getName();
        }
        return null;
    }
}
