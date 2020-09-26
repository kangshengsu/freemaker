package com.fm.framework.core.enums;

/**
 * 删除标志枚举
 *
 * @author fengyonglei1
 * @create 2019-05-20 14:50
 **/
public enum DeleteEnum {


    VALID(0,"有效"),
    INVALID(1,"无效");

    private int value;
    private String desc;
    DeleteEnum(int value, String desc){
        this.value=value;
        this.desc=desc;
    }


    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
