package com.fm.api.gw.vo.evaluation;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhangleqi
 * @date 2020/10/9
 */
@Data
public class OverallEvaluationVO {
    /**
     * 被评价主键
     **/
    private Long freelancerId;
    /**
     * 总体评价
     */
    public BigDecimal totalScore;
    /**
     * 响应速度打分
     */
    public BigDecimal responseSpeed;
    /**
     * 沟通能力打分
     */
    public BigDecimal communicateCapacity;
    /**
     *完成时间打分
     */
    public BigDecimal completionTime;
    /**
     * 完成质量打分
     */
    public BigDecimal accomplishQuality;
    /**
     * 推荐意向
     */
    public BigDecimal recommendScore;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;

    /**
     * 评价数量
     */
    public Integer evaluationCount;
}
