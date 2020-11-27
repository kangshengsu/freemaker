package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/24 15:19
 */
@Getter
@AllArgsConstructor
public enum JobCateIsNew {
    NEW(10,"上新"),
    NOT_NEW(20,"不上新");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static JobCateIsNew get(Integer code) {
        if (code == null) {
            return null;
        }
        JobCateIsNew[] _enums = values();
        for (JobCateIsNew _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
