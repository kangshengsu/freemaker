package com.fm.api.gw.vo.evaluation;

import lombok.Data;

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
     *完成时间打分
     */
    public Double completionTime;
    /**
     * 完成质量打分
     */
    public Double accomplishQuality;
    /**
     * 推荐意向
     */
    public Double recommendScore;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;
}
