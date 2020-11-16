package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 预算计算方式
 *
 * @author zhangleqi
 * @date 2020/10/25
 */
@Getter
@AllArgsConstructor
public enum BudgetType {

    HOURLY_WAGE(0, "时薪"),
    FIXED_PRICE(1, "一口价"),
    INTERVIEW(2, "面议");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;


    /**
     * 根据code获取name
     *
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        if (code == null) {
            return "";
        }
        for (BudgetType value : BudgetType.values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return "";
    }

}
