package com.fm.api.gw.vo.recommend.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.recommend.RecommendProductionVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.production.RecommendProduction;
import com.fm.framework.core.service.FileService;
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
public abstract class RecommendMapper extends CommonMapper {

    @Mappings({
            @Mapping(target = "images", source = "attachmentInfos"),
            @Mapping(target = "skills", source = "productionSkillRelations")
    })
    public abstract RecommendProductionVO toRecommendProductionVO(RecommendProduction recommendProduction);

    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    public abstract  AttachmentVO toAttachmentVO(AttachmentInfo attachmentInfo);

}
