package com.fm.business.base.enums;

import lombok.AllArgsConstructor;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/26 19:57
 */
@AllArgsConstructor
public enum JobCateHomeShow {
    SHOW(10,"展示"),
    NOT_SHOW(20,"不展示");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static JobCateHomeShow get(Integer code) {
        if (code == null) {
            return null;
        }
        JobCateHomeShow[] _enums = values();
        for (JobCateHomeShow _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
