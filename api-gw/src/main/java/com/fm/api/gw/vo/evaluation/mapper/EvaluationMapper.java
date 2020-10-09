package com.fm.api.gw.vo.evaluation.mapper;

import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.framework.core.service.FileService;
import com.fm.framework.core.utils.SpringUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Mapper(componentModel = "spring")
public interface EvaluationMapper {


    @Mapping(target = "images", source = "attachmentInfos")
    EvaluationInfoVO toEvaluationListVO(EvaluationInfo evaluationInfo);


    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    AttachmentVO toAttachmentVO(AttachmentInfo attachmentInfo);



    @Named("fullPath")
    default String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return SpringUtil.getBean(FileService.class).getFullPath(path);
        }
        return null;
    }

}
