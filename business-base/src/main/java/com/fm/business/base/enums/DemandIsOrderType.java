package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/11 15:28
 */
@Getter
@AllArgsConstructor
public enum DemandIsOrderType {
    ORDERED(10,"已下单"),
    NOT_ORDERED(20,"未下单");

    private Integer code;
    private String name;

    public DemandIsOrderType get(Integer code){
        if(code == null) {
            return null;
        }
        for (DemandIsOrderType value : DemandIsOrderType.values()) {
            if (code == value.code) {
                return value;
            }
        }
        return null;
    }
}
