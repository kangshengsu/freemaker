package com.fm.business.base.enums;

public enum OrderOperateRoleType {

    EMPLOYER(10,"雇佣者"),
    FREELANCER(20,"自由职业者");

    private Integer code;
    private String name;

    OrderOperateRoleType(int type, String name) {
        this.code = type;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() { return this.name; }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static OrderOperateRoleType get(Integer code) {
        if (code == null) {
            return null;
        }
        OrderOperateRoleType[] _enums = values();
        for (OrderOperateRoleType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
