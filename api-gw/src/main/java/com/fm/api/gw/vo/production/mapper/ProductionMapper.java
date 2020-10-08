package com.fm.api.gw.vo.production.mapper;

import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.service.FileService;
import com.fm.framework.core.utils.SpringUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * liuduo
 * <p>
 * 作品相关映射
 */
@Mapper(componentModel = "spring")
public interface ProductionMapper {

    @Mapping(target = "images", source = "attachmentInfos")
    @Mapping(target = "statusName", source = "status", qualifiedByName = "statusConvert")
    ProductionListVO toProductionListVO(ProductionInfo productionInfo);

    @Mappings({
            @Mapping(target = "images", source = "attachmentInfos"),
            @Mapping(target = "statusName", source = "status", qualifiedByName = "statusConvert"),
            @Mapping(target = "skills", source = "productionSkillRelations")
    })
    ProductionViewVO toProductionViewVO(ProductionInfo productionInfo);

    @Mappings({
            @Mapping(source = "images", target = "attachmentInfos"),
            @Mapping(source = "skills", target = "productionSkillRelations")
    })
    ProductionInfo toProduction(ProductionApiVO productionApiVO);

    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    AttachmentVO toAttachmentVO(AttachmentInfo attachmentInfo);

    @Named("statusConvert")
    default String statusConvert(Integer status) {
        if (ProductionStatus.get(status) != null) {
            return ProductionStatus.get(status).getName();
        }
        return null;
    }

    /**
     * 补全路径
     * @param path
     * @return
     */
    @Named("fullPath")
    default String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return SpringUtil.getBean(FileService.class).getFullPath(path);
        }
        return null;
    }
}
