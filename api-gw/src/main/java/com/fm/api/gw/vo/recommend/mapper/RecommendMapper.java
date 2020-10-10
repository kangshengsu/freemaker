package com.fm.api.gw.vo.recommend.mapper;

import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.api.gw.vo.production.relation.ReviewInfoVO;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.api.gw.vo.recommend.RecommendProductionVO;
import com.fm.business.base.enums.ProductionReviewStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionReviewInfo;
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
public abstract class RecommendMapper {

    @Autowired
    private FileService fileService;

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

    /**
     * 补全路径
     * @param path
     * @return
     */
    @Named("fullPath")
     String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return fileService.getFullPath(path);
        }
        return null;
    }
}
