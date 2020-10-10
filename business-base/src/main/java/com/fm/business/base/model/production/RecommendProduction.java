package com.fm.business.base.model.production;

import com.fm.business.base.model.evaluation.OverallEvaluation;
import lombok.Data;

/**
 * @author zhangleqi
 * @date 2020/10/10
 */
@Data
public class RecommendProduction extends ProductionInfo{

    /**
     * 综合评价
     */
    private transient OverallEvaluation overallEvaluation;

}
