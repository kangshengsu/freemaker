package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 交付方式
 *
 * @author zhangleqi
 * @date 2020/10/25
 */
@Getter
@AllArgsConstructor
public enum DeliveryType {

    REMOTE(0, "远程"),
    SCENE(1, "现场");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;


    /**
     * 根据code获取name
     *
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        if (code == null) {
            return "";
        }
        for (DeliveryType value : DeliveryType.values()) {
            if (value.getCode().equals(code)) {
                return value.getName();
            }
        }
        return "";
    }


}
