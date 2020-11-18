/**
 * @filename:BdJobSkillDao 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.dao.evaluationinfo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.OverallEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Wrapper;

/**
 * @Description:(评价信息数据访问层)
 * @version: V1.0
 * @author: LiuDuo
 */
@Mapper
public interface IEvaluationInfoMapper extends BaseMapper<EvaluationInfo> {
    /**
     * 获取 自由职业者 以往评价的总分 以及评价条数
     * @param productionId
     * @param
     * @return
     */
    OverallEvaluation findOverallEvaluationByProductionId(@Param("productionId") Long productionId, @Param("maxCount") Integer maxCount);
}
