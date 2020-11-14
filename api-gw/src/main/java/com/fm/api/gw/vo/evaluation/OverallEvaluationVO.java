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
     *完成时间打分
     */
    public String completionTime;
    /**
     * 完成质量打分
     */
    public String accomplishQuality;
    /**
     * 推荐意向
     */
    public String recommendScore;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;

    /**
     * 评价数量
     */
    public Integer evaluationCount;
}
