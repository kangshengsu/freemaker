package com.fm.framework.core.exception;

import lombok.Getter;

/**
 * <p>业务异常</p>
 *
 * @author clufeng
 */
@Getter
public class BusinessException extends RuntimeException {

    public static int BUSINESS_DEFAULT_CODE = 400;

    private final int errorCode;

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = BUSINESS_DEFAULT_CODE;
    }

}
