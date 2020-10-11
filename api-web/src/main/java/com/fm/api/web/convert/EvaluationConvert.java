package com.fm.api.web.convert;

import com.fm.api.web.vo.evaluation.EvaluationInfoVO;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Mapper
public interface EvaluationConvert {

    EvaluationConvert INSTANCE = Mappers.getMapper(EvaluationConvert.class);

    @Mapping(target = "images", source = "attachmentInfos")
    EvaluationInfoVO to(EvaluationInfo evaluationInfo);


}
