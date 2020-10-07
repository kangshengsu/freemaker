package com.fm.business.base.enums;

public enum OrderStatus {
    INIT_10(10,"已下单", 0, OrderOperateRoleType.FREELANCER.getCode()),

    REJECT_20(20,"已拒单", 7, OrderOperateRoleType.FREELANCER.getCode()),

    TAKING_30(30,"已接单", 1, OrderOperateRoleType.EMPLOYER.getCode()),

    MAKING_40(40,"制作中", 2, OrderOperateRoleType.FREELANCER.getCode()),

    CHECKING_50(50,"待验收", 3, OrderOperateRoleType.EMPLOYER.getCode()),

    CHECK_FAIL_60(60,"验收不通过", 4, OrderOperateRoleType.EMPLOYER.getCode()),

    FINISHED_70(70,"已完成", 5, OrderOperateRoleType.EMPLOYER.getCode()),

    EVALUATED_80(80,"已评价", 6, OrderOperateRoleType.EMPLOYER.getCode());


    private Integer code;
    private String name;
    private Integer step;

    /**
     * 操作类型（10：雇佣者操作; 20：自由职业者操作）
     */
    private Integer operateType;
    OrderStatus(int type, String name, Integer step, Integer operateType) {
        this.code = type;
        this.name = name;
        this.step = step;
        this.operateType = operateType;
    }

    public Integer getCode() {
        return this.code;
    }

    public Integer getStep() {
        return this.step;
    }

    public String getName() { return this.name; }

    public Integer getOperateType() { return this.operateType; }

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
