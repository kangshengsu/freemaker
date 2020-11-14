package com.fm.business.base.model.evaluation;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

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
    public String totalScore;
    /**
     * 响应速度打分
     */
    public String responseSpeed;
    /**
     * 沟通能力打分
     */
    public String communicateCapacity;
    /**
     * 完成时间
     */
    public String completionTime;
    /**
     * 完成质量
     */
    public String accomplishQuality;
    /**
     * 推荐意向
     */
    public String recommendScore;

    /**
     * 总体评价 总分
     */
    public BigDecimal totalScoreSum;
    /**
     * 响应速度打分 总分
     */
    public BigDecimal responseSpeedSum;
    /**
     * 沟通能力打分 总分
     */
    public BigDecimal communicateCapacitySum;
    /**
     * 完成时间
     */
    public BigDecimal completionTimeSum;
    /**
     * 完成质量
     */
    public BigDecimal accomplishQualitySum;
    /**
     * 推荐意向 总分
     */
    public BigDecimal recommendScoreSum;

    /**
     * 评价数量
     */
    public Integer evaluationCount;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;
}
