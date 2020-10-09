/**
 * @filename:BdJobSkillService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service;

import com.fm.business.base.model.evaluation.EvaluationInfoTag;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Description:(评价打标服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IEvaluationInfoTagService extends Service<EvaluationInfoTag> {
    /**
     * 根据订单主键获取订单详情
     * @param orderIds 订单主键
     * @return
     */
    List<EvaluationInfoTag> getTagsByEvaluationIds(Collection<Long> evaluationIds);
}
