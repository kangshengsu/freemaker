package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/3 14:49
 */
@Getter
@AllArgsConstructor
public enum IsReplace {
    REPLACE(10,"代发"),
    NOT_REPLACE(20,"不代发");

    private Integer code;
    private String name;


    public static IsReplace get(Integer code) {
        if (code == null) {
            return null;
        }
        IsReplace[] _enums = values();
        for (IsReplace _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
