package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  DistributionStatus {

    /**
     * 0-未分配
     */
    NO_DISTRIBUTION(0,"未分配"),

    /**
     * 1-已分配
     */
    YES_DISTRIBUTION(1,"已分配");

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
    public static DistributionStatus get(Integer code) {
        if (code == null) {
            return null;
        }
        DistributionStatus[] _enums = values();
        for (DistributionStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
