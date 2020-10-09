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
