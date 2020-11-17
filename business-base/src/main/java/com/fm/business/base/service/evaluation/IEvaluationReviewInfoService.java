package com.fm.business.base.service.evaluation;

import com.fm.business.base.enums.EvaluationReviewStatus;
import com.fm.business.base.enums.EvaluationStatusEnum;
import com.fm.business.base.model.evaluation.EvaluationReviewInfo;
import com.fm.framework.core.service.Service;

public interface IEvaluationReviewInfoService extends Service<EvaluationReviewInfo> {

    boolean review(EvaluationReviewInfo convert, EvaluationReviewStatus evaluationReviewStatus);
}
