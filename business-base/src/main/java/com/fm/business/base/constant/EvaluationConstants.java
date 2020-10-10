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
     * 结果打分
     */
    Double RESULT_SCORE_MAX = Double.valueOf("5.0");
    /**
     * 过程打分
     */
    Double PROCESS_SCORE_MAX= Double.valueOf("5.0");
    /**
     * 推荐意向
     */
    Double RECOMMEND_SCORE_MAX = Double.valueOf("5.0");

    /**
     * 样本数量
     */
    Integer EVALUATION_DEFAULT_COUNT = Integer.valueOf(100);

}
