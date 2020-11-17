package com.fm.business.base.service.evaluation.impl;

import com.fm.business.base.dao.evaluationinfo.IEvaluationReviewInfoMapper;
import com.fm.business.base.enums.EvaluationReviewStatus;
import com.fm.business.base.enums.EvaluationStatusEnum;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.EvaluationReviewInfo;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.business.base.service.evaluation.IEvaluationReviewInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qdl
 * @time 2020.11.17
 * @version V1.1
 */

@Slf4j
@Service
public class EvaluationReviewInfoServiceImpl extends AuditBaseService<IEvaluationReviewInfoMapper, EvaluationReviewInfo> implements IEvaluationReviewInfoService {

    @Autowired
    private IEvaluationInfoService evaluationInfoService;

    @Override
    public boolean review(EvaluationReviewInfo evaluationReviewInfo, EvaluationReviewStatus evaluationReviewStatus) {
        /**
         * 检查当前评价审核状态
         */
        EvaluationInfo evaluationInfo = evaluationInfoService.get(evaluationReviewInfo.getEvaluationId());
        if (evaluationInfo == null){
            throw new BusinessException("评价不存在");
        }else if (!EvaluationReviewStatus.NOT_REVIEW.getCode().equals(evaluationInfo.getStatus())){
            throw new BusinessException("只允许审核【未审核】的评价");
        }
        /**
         * 设置审核人
         */
        evaluationReviewInfo.setReviewerId(Context.getCurrUserId());
        /**
         * 设置审核结果
         */
        evaluationReviewInfo.setStatus(evaluationReviewStatus.getCode());
        /**
         * 保存审核结果
         */
        if (!save(evaluationReviewInfo)){
            /**
             * 保存失败
             */
            return false;
        }
        /**
         *  更新评价状态
         */
        EvaluationInfo updateEvaluationInfo = new EvaluationInfo();
        updateEvaluationInfo.setId(evaluationReviewInfo.getEvaluationId());
        if (EvaluationReviewStatus.REVIEW_PASS.equals(evaluationReviewStatus)){
            updateEvaluationInfo.setStatus(EvaluationStatusEnum.AUDIT_PASS.getCode());
        }else if (EvaluationReviewStatus.REVIEW_NOT_PASS.equals(evaluationReviewStatus)){
            updateEvaluationInfo.setStatus(EvaluationStatusEnum.AUDIT_FAIL.getCode());
        }
        if (!evaluationInfoService.updateStatus(updateEvaluationInfo)){
            throw new BusinessException("审核评价时更新评价状态失败");
        }

        return true;
    }
}
