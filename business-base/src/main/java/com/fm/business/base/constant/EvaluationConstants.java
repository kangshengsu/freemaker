package com.fm.business.base.constant;

import java.math.BigDecimal;

/**
 * 评价相关常量
 */
public interface EvaluationConstants {

    /**
     * 总体评价
     */
    BigDecimal TOTAL_SCORE_MAX = BigDecimal.valueOf(5.00);
    /**
     * 响应速度打分
     */
    BigDecimal RESPONSE_SPEED_MAX = BigDecimal.valueOf(5.00);
    /**
     * 沟通能力打分
     */
    BigDecimal COMMUNICATE_CAPACITY_MAX= BigDecimal.valueOf(5.00);
    /**
     * 完成时间打分
     */
    BigDecimal COMPLETION_TIME_MAX= BigDecimal.valueOf(5.00);

    /**
     * 完成质量打分
     */
    BigDecimal ACCOMPLISH_QUALITY_MAX= BigDecimal.valueOf(5.00);

    /**
     * 推荐意向
     */
    BigDecimal RECOMMEND_SCORE_MAX = BigDecimal.valueOf(5.00);

    /**
     * 样本数量
     */
    Integer EVALUATION_DEFAULT_COUNT = Integer.valueOf(100);

}
