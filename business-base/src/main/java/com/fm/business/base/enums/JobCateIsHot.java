package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/24 15:23
 */
@Getter
@AllArgsConstructor
public enum JobCateIsHot {
    HOT(10,"火热"),
    NOT_HOT(20,"不火热");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return name;
    }

    public static JobCateIsHot get(Integer code) {
        if (code == null) {
            return null;
        }
        JobCateIsHot[] _enums = values();
        for (JobCateIsHot _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
