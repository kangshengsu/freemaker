package com.fm.business.base.enums;

import com.fm.framework.core.exception.BusinessException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 小程序按评分排序枚举类
 */
@Getter
public enum MiniAppEvaluationEnum {
    ALL(0,"默认排序"),
    ASC(10,"评分升序"),
    DESC(20,"评分降序");

    private Integer code;
    private String name;
    MiniAppEvaluationEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MiniAppEvaluationEnum resolve(Integer code){
        return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst().orElseThrow(() -> new BusinessException("MiniAppEvaluationEnum type error"));
    }
}
