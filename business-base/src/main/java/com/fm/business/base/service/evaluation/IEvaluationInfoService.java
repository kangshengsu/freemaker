/**
 * @filename:BdJobSkillService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.evaluation;

import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.OverallEvaluation;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:(评价信息服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IEvaluationInfoService extends Service<EvaluationInfo> {
    /**
     * 根据作者和岗位获取评价信息
     * @param str
     * @return
     */
    Page<EvaluationInfo> findByCateAndFreelancerPage(Long jobCateId, Long freelancerId, Integer limit, Integer currentPage, Integer pageSize,Integer storeSort, Integer timeSort);
    /**
     * 根据作者和岗位获取总体评价信息
     * @param str
     * @return
     */
    OverallEvaluation findOverallEvaluationByCateAndFreelancer(Long jobCateId, Long freelancerId);

    /**
     * 根据作品ID获取评价信息
     * @param orderId
     * @return
     */
    EvaluationInfo findByOrderId(Long orderId);

}
