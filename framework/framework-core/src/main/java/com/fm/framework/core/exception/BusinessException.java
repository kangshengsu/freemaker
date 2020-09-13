package com.fm.framework.core.exception;

import lombok.Getter;

/**
 * <p>业务异常</p>
 *
 * @author clufeng
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int errorCode;

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
