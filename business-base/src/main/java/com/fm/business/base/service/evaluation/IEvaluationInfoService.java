/**
 * @filename:BdJobSkillService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.evaluation;

import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.framework.core.service.Service;

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
    List<EvaluationInfo> findByCateAndFreelancer( Long jobCateId, Long freelancerId);
}
