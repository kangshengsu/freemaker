package com.fm.business.base.enums;

import lombok.Getter;

@Getter
public enum LanguageEnum {

    CHINESE(0, "zh_CN","汉语"),
    ENGLISH(1, "en","英语"),
    JAPANESE(2, "","日语");

    LanguageEnum(Integer index,String code, String desc) {
        this.index = index;
        this.code = code;
        this.desc = desc;
    }

    /**
     * 语言枚举值
     */
    private Integer index;

    /**
     * 语言编码
     */
    private String code;

    /**
     * 语言描述
     */
    private String desc;

    public static Integer getIndexByCode(String code) {
        for (LanguageEnum item : values()) {
            if (item.getCode().equals(code)) {
                return item.getIndex();
            }
        }
        return null;
    }

}
