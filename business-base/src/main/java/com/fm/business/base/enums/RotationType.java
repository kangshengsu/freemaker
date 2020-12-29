package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author G
 * @date 2020/12/25 下午3:38
 */
@Getter
@AllArgsConstructor
public enum RotationType {
    PD(10,"需求/服务"),
    PAY(20,"支付"),
    EVALUATE(30,"评价");

    private Integer code;
    private String name;

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static RotationType get(Integer code) {
        if(code == null){
            return null;
        }
        RotationType[] _enums = values();
        for (RotationType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
