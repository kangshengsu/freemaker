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
     * 结果打分
     */
    public Double resultScore;
    /**
     * 过程打分
     */
    public Double processScore;
    /**
     * 推荐意向
     */
    public Double recommendScore;
    /**
     * 总体评价描述
     */
    public String totalEvaluationDesc;
}
