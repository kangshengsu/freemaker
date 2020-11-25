package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SettlementStatus {

    /**
     * 10-未结算
     */
    UNSETTLED(10,"未结算"),

    /**
     * 20-已结算
     */
    SETTLED(20,"已结算");

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
    public static SettlementStatus get(Integer code) {
        if (code == null) {
            return null;
        }
        SettlementStatus[] _enums = values();
        for (SettlementStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
