package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/14 16:05
 */
@Getter
@AllArgsConstructor
public enum  DemandType {
    DEMAND(10,"需求"),
    A_REWARD(20,"悬赏招聘");

    private Integer code;
    private String name;

    public static String get(Integer code){
        if (code == null) {
            return null;
        }
        for (DemandType value : values()) {
            if (code == value.code) {
                return value.name;
            }
        }
        return null;
    }
}
