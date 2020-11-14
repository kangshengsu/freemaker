package com.fm.business.base.enums;

import com.fm.framework.core.exception.BusinessException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MiniAppEvaluationTimeEnum {
    ALL(0,"默认排序"),
    ASC(10,"按评价时间升序"),
    DESC(20,"按评价时间降序");

    private Integer code;
    private String name;


    MiniAppEvaluationTimeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MiniAppEvaluationTimeEnum resolve(Integer code){
        return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst().orElseThrow(() -> new BusinessException("MiniAppOrderTimeEnum type error"));
    }
}
