package com.fm.business.base.constant;

/**
 * 评价相关常量
 */
public interface EvaluationConstants {

    /**
     * 总体评价
     */
    Double TOTAL_SCORE_MAX = Double.valueOf("5.0");
    /**
     * 响应速度打分
     */
    Double RESPONSE_SPEED_MAX = Double.valueOf("5.0");
    /**
     * 沟通能力打分
     */
    Double COMMUNICATE_CAPACITY_MAX= Double.valueOf("5.0");
    /**
     * 完成时间打分
     */
    Double COMPLETION_TIME_MAX= Double.valueOf("5.0");

    /**
     * 完成质量打分
     */
    Double ACCOMPLISH_QUALITY_MAX= Double.valueOf("5.0");

    /**
     * 推荐意向
     */
    Double RECOMMEND_SCORE_MAX = Double.valueOf("5.0");

    /**
     * 样本数量
     */
    Integer EVALUATION_DEFAULT_COUNT = Integer.valueOf(100);

}
