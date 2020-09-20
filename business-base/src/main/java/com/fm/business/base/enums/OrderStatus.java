package com.fm.business.base.enums;

public enum OrderStatus {


    INIT_10(10,"初始态"),

    REJECT_20(20,"已拒单"),

    TAKING_30(30,"已接单"),

    PAID_40(40,"已支付"),

    MAKING_50(50,"制作中"),

    CHECKING_60(60,"待验收"),

    FINISHED_70(70,"已完成"),

    EVALUATED_80(80,"已评价");


    private Integer code;
    private String name;
    OrderStatus(int type, String name) {
        this.code = type;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static OrderStatus get(Integer code) {
        if (code == null) {
            return null;
        }
        OrderStatus[] _enums = values();
        for (OrderStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
