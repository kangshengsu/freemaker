package com.fm.business.base.enums;

public enum UserType {


    EMPLOYER(10,"雇佣者"),

    FREELANCER(20,"开发者");


    private Integer code;
    private String name;
    UserType(int type, String name) {
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
    public static UserType get(Integer code) {
        if (code == null) {
            return null;
        }
        UserType[] _enums = values();
        for (UserType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
