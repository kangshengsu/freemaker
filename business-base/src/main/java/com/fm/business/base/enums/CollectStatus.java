package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/22 17:25
 */
@Getter
@AllArgsConstructor
public enum CollectStatus {
    COLLECT(10,"收藏"),
    CANCEL_COLLECT(20,"取消收藏");

    private Integer code;
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
