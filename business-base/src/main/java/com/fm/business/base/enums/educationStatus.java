package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum educationStatus {

    JMSCHOOL(10,"初中及以下"),

    PSCHOOL(20,"中专/中技"),

    HSCHOOL(30,"高中"),

    JCSCHOOL(40,"大专"),

    UNDERGRADUATE(50,"本科"),

    MASTER(60,"硕士"),

    DOCTOR(70,"博士");

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
     * @param code
     * @return
     */
    public static educationStatus get(Integer code) {
        if(code == null){
            return null;
        }
        educationStatus[] _enums = values();
        for (educationStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 根据code获取name
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        educationStatus educationStatus = get(code);
        if (educationStatus==null) {
            return "";
        }
        return educationStatus.getName();
    }
}
