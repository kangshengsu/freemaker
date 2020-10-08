package com.fm.business.base.service.evaluation.impl;

import com.fm.business.base.dao.evaluationinfo.IEvaluationInfoMapper;
import com.fm.business.base.dao.evaluationinfo.IEvaluationInfoTagMapper;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.EvaluationInfoTag;
import com.fm.business.base.service.IEvaluationInfoTagService;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangleqi
 * @date 2020/10/9
 */
@Slf4j
@Service("evaluationInfoTagService")
public class EvaluationInfoTagServiceImpl  extends AuditBaseService<IEvaluationInfoTagMapper, EvaluationInfoTag> implements IEvaluationInfoTagService {



}
