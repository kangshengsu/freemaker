package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemandRecommendType {
    INIT(10, "推荐"),
    RECEIVING(20, "接单"),
    REFUSE(30, "拒单");

    private Integer type;
    private String name;

    DemandRecommendType(int type, String name) {
        this.type = type;
        this.name = name;
    }


    /**
     *根据code获取name
     */
    public static String getName(Integer code){
        if (code == null) {
            return null;
        }
        for (DemandRecommendType value : DemandRecommendType.values()) {
            if (value.getType() == code) {
                return value.getName();
            }
        }
        return null;
    }
}
