package com.fm.business.base.enums;

/**
 * @author zhangleqi
 * @date 2020-10-02 6:41 下午
 */
public enum MiniAppOrderTypeEnum {

    ALL(0,""),
    RECEIVED(1, ""),
    INITIATE(2,"");

    private Integer index;

    private String name;

    MiniAppOrderTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }
}
