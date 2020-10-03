package com.fm.business.base.enums;

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

    public Integer getType() {
        return this.type;
    }
}
