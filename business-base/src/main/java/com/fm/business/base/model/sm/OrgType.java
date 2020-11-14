package com.fm.business.base.model.sm;

/**
 * 组织类型
 * @author hubo
 * @version 1.0.0
 **/
public enum OrgType {

    CORP(1), DEPT(2);

    OrgType(int code) {
        this.code = code;
    }

    private final int code;

    public int getCode() {
        return code;
    }
}
