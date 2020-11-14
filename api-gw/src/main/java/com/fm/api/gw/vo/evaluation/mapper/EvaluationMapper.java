package com.fm.api.gw.vo.evaluation.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.employer.mapper.EmployerInfoMapper;
import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.evaluation.OverallEvaluationVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.freelancer.mapper.FreelancerInfoMapper;
import com.fm.business.base.enums.EvaluationEnum;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.OverallEvaluation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
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
public abstract class EvaluationMapper extends CommonMapper {



    @Mapping(target = "images", source = "attachmentInfos")
    @Mapping(target = "freelancerInfo", source = "freelancerInfo", qualifiedByName = "freelancerInfoConvert")
    @Mapping(target = "employerInfo", source = "employerInfo", qualifiedByName = "employerInfoConvert")
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
    String totalEvaluationDesc(String totalScore) {
        return EvaluationEnum.getEvaluationDescByScore(totalScore);
    }


}
