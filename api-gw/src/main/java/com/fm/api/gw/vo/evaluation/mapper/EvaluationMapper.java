package com.fm.api.gw.vo.evaluation.mapper;

import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.evaluation.OverallEvaluationVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.business.base.enums.EvaluationEnum;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.OverallEvaluation;
import com.fm.framework.core.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Mapper(componentModel = "spring")
public abstract class EvaluationMapper {


    @Autowired
    private FileService fileService;

    @Mapping(target = "images", source = "attachmentInfos")
    public abstract EvaluationInfoVO toEvaluationListVO(EvaluationInfo evaluationInfo);

    @Mappings({
            @Mapping(source = "totalScore", target = "totalEvaluationDesc", qualifiedByName="totalEvaluationDesc")
    })
    public abstract OverallEvaluationVO toOverallEvaluationVO(OverallEvaluation overallEvaluation);

    @Mappings({
            @Mapping(source = "images", target = "attachmentInfos")
    })
    public abstract EvaluationInfo toEvaluation(EvaluationInfoVO evaluationInfoVO);



    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    abstract AttachmentVO toAttachmentVO(AttachmentInfo attachmentInfo);

    @Named("totalEvaluationDesc")
    String totalEvaluationDesc(Double totalScore) {
        return EvaluationEnum.getEvaluationDescByScore(totalScore);
    }

    @Named("fullPath")
    String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return fileService.getFullPath(path);
        }
        return null;
    }

}
