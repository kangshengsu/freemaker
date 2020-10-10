package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 作品状态
 * @author liuduo
 * @version 1.0.0
 *
 *   10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除
 **/
@Getter
@AllArgsConstructor
public enum ProductionStatus {
    /**
     * 10-未发布
     */
    NOT_RELEASE(10,"未发布"),
    /**
     * 20-审核中
     */
    REVIEW(20,"审核中"),
    /**
     * 30-审核未通过
     */
    REVIEW_NOT_PASS(30,"审核未通过"),
    /**
     * 40-已发布
     */
    RELEASE(40,"已发布");
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
    public static ProductionStatus get(Integer code) {
        if(code == null){
            return null;
        }
        ProductionStatus[] _enums = values();
        for (ProductionStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 根据code获取name
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        ProductionStatus productionStatus = get(code);
        if (productionStatus==null) {
            return "";
        }
        return productionStatus.getName();
    }


}
