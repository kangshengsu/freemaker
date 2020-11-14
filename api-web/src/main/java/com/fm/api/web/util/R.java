package com.fm.api.web.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果.
 */
@Data
@NoArgsConstructor
public class R {
    // 常用返回码
    public static int SUCCESS_CODE = ResultCodes.SUCCESS.value();
    public static String SUCCESS_MSG = ResultCodes.SUCCESS.reason();
    public static int FAILED_CODE = ResultCodes.FAILED.value();
    public static String FAILED_MSG = ResultCodes.FAILED.reason();

    //状态码
    private int code = FAILED_CODE;
    //状态描述
    private String message;
    //数据载体
    private Object data;

    private String traceId;

    public static R create(){
        return new R();
    }

    public static R createFailR(){
        return new R().code(FAILED_CODE);
    }

    public static R createSuccessR(){
        return new R().code(SUCCESS_CODE).message(SUCCESS_MSG);
    }

    public R code(int code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R data(Object data){
        this.setData(data);
        return this;
    }
}
