package com.fm.business.base.enums;

import lombok.Getter;

@Getter
public enum LanguageEnum {

    CHINESE(10, "中文","zh_CN"),
    ENGLISH(20, "英文","en");

    LanguageEnum(Integer code,String name, String keyword) {
        this.code = code;
        this.name = name;
        this.keyword = keyword;
    }

    /**
     * 语言枚举值
     */
    private Integer code;

    /**
     * 语言
     */
    private String name;

    /**
     * 语言小程序关键字
     */
    private String keyword;

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static LanguageEnum get(Integer code) {
        if(code == null){
            return null;
        }
        LanguageEnum[] _enums = values();
        for (LanguageEnum _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

}
