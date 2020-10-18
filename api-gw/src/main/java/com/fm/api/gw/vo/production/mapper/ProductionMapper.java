package com.fm.api.gw.vo.production.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.freelancer.mapper.FreelancerInfoMapper;
import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.production.relation.ReviewInfoVO;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.enums.ProductionReviewStatus;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionReviewInfo;
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
public abstract class ProductionMapper extends CommonMapper {

    @Mapping(target = "images", source = "attachmentInfos")
    @Mapping(target = "statusName", source = "status", qualifiedByName = "statusConvert")
    @Mapping(target = "freelancerInfo", source = "freelancerInfo", qualifiedByName = "freelancerInfoConvert")

    public abstract  ProductionListVO toProductionListVO(ProductionInfo productionInfo);

    @Mappings({
            @Mapping(target = "images", source = "attachmentInfos"),
            @Mapping(target = "statusName", source = "status", qualifiedByName = "statusConvert"),
            @Mapping(target = "skills", source = "productionSkillRelations"),
            @Mapping(target = "freelancerInfo", source = "freelancerInfo", qualifiedByName = "freelancerInfoConvert")
    })
    public abstract  ProductionViewVO toProductionViewVO(ProductionInfo productionInfo);

    @Mappings({
            @Mapping(source = "images", target = "attachmentInfos"),
            @Mapping(source = "skills", target = "productionSkillRelations")
    })
    public abstract  ProductionInfo toProduction(ProductionApiVO productionApiVO);

    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    public abstract  AttachmentVO toAttachmentVO(AttachmentInfo attachmentInfo);

    @Mappings({
            @Mapping(target = "statusName", source = "status", qualifiedByName = "reviewStatusConvert")
    })
    public abstract  ReviewInfoVO toReviewInfoVO(ProductionReviewInfo productionReviewInfo);

    @Named("statusConvert")
    String statusConvert(Integer status) {
        if (ProductionStatus.get(status) != null) {
            return ProductionStatus.get(status).getName();
        }
        return null;
    }

    @Named("reviewStatusConvert")
    String reviewStatusConvert(Integer status) {
        if (ProductionStatus.get(status) != null) {
            return ProductionReviewStatus.get(status).getName();
        }
        return null;
    }

}
