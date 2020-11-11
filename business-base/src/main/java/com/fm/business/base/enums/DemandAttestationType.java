package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemandAttestationType {

    /**
     * 0-未认证
     */
    NO_ATTESTATION(0, "未认证"),

    /**
     * 1-已认证
     */
    YES_ATTESTATION(1, "已认证");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static DemandAttestationType get(Integer code) {
        if (code == null) {
            return null;
        }
        DemandAttestationType[] _enums = values();
        for (DemandAttestationType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
