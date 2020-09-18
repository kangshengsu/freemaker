package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 作品审核记录状态
 * @author liuduo
 * @version 1.0.0
 *
 *   10-未审核，20-审核未通过，30-审核通过
 **/
@Getter
@AllArgsConstructor
public enum ProductionReviewStatus {
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
    public static ProductionReviewStatus get(Integer code) {
        if(code == null){
            return null;
        }
        ProductionReviewStatus[] _enums = values();
        for (ProductionReviewStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

}
