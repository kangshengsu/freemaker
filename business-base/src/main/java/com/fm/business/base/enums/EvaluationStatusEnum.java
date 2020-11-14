package com.fm.business.base.enums;

/**
 * @author QDL
 * @Date 2020/11/12
 */
public enum EvaluationStatusEnum {
        AUDIT_INIT(10,"审核中"),
        AUDIT_FAIL(20,"审核不通过"),
        AUDIT_PASS(30,"审核通过")
    ;

        private Integer code;
        private String name;
    EvaluationStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static EvaluationStatusEnum get(Integer code) {
        if (code == null) {
            return null;
        }
        EvaluationStatusEnum[] _enums = values();
        for (EvaluationStatusEnum _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
