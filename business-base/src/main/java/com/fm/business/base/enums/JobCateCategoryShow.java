package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/24 15:25
 */
@Getter
@AllArgsConstructor
public enum JobCateCategoryShow {
    SHOW(10,"展示"),
    NOT_SHOW(20,"不展示");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return name;
    }

    public static JobCateCategoryShow get(Integer code) {
        if (code == null) {
            return null;
        }
        JobCateCategoryShow[] _enums = values();
        for (JobCateCategoryShow _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

}
