package com.fm.business.base.enums;

public enum OrderStatus {


    INIT_10(10,"下单", 1),

    REJECT_20(20,"已拒单", 2),

    TAKING_30(30,"已接单", 2),

    PAID_40(40,"已支付", 3),

    MAKING_50(50,"制作中", 4),

    CHECKING_60(60,"待验收", 5),

    FINISHED_70(70,"已完成", 6),

    EVALUATED_80(80,"已评价", 7);


    private Integer code;
    private String name;
    private Integer step;
    OrderStatus(int type, String name, Integer step) {
        this.code = type;
        this.name = name;
        this.step = step;
    }

    public Integer getCode() {
        return this.code;
    }

    public Integer getStep() {
        return this.step;
    }

    public String getName() { return this.name; }

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
