package com.fm.business.base.enums;

public enum TagStatus {
    ENABLE(10,"启用"),

    DISABLE(20,"停用");

    private Integer code;
    private String name;
    TagStatus(int type, String name) {
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
    public static TagStatus get(Integer code) {
        if (code == null) {
            return null;
        }
        TagStatus[] _enums = values();
        for (TagStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
