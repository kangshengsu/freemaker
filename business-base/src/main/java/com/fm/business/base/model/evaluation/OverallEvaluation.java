package com.fm.business.base.model.evaluation;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangleqi
 * @date 2020/10/9
 */
@Data
public class OverallEvaluation implements Serializable {
    /**
     * 被评价主键
     **/
    private Long freelancerId;
    /**
     * 总体评价
     */
    public Double totalScore;
    /**
     * 响应速度打分
     */
    public Double responseSpeed;
    /**
     * 沟通能力打分
     */
    public Double communicateCapacity;
    /**
     * 完成时间
     */
    public Double completionTime;
    /**
     * 完成质量
     */
    public Double accomplishQuality;
    /**
     * 推荐意向
     */
    public Double recommendScore;

    /**
     * 总体评价 总分
     */
    public Double totalScoreSum;
    /**
     * 响应速度打分 总分
     */
    public Double responseSpeedSum;
    /**
     * 沟通能力打分 总分
     */
    public Double communicateCapacitySum;
    /**
     * 完成时间
     */
    public Double completionTimeSum;
    /**
     * 完成质量
     */
    public Double accomplishQualitySum;
    /**
     * 推荐意向 总分
     */
    public Double recommendScoreSum;

    /**
     * 评价数量
     */
    public Integer evaluationCount;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;
}
