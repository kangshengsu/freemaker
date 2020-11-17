package com.fm.business.base.enums;

import com.fm.business.base.model.evaluation.EvaluationReviewInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  EvaluationReviewStatus {
    /**
     * 10-未发布
     */
    NOT_REVIEW(10,"未审核"),
    /**
     * 20-审核未通过
     */
    REVIEW_NOT_PASS(20,"审核未通过"),
    /**
     * 30-审核通过
     */
    REVIEW_PASS(30,"审核通过");
    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static EvaluationReviewStatus get(Integer code) {
        if(code == null){
            return null;
        }
        EvaluationReviewStatus[] _enums = values();
        for (EvaluationReviewStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
