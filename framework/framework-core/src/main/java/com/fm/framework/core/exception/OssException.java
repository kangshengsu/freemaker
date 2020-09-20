package com.fm.framework.core.exception;

/**
 * 云存储异常
 *
 * @author zhangleqi
 * @date 2020-09-19 12:08 上午
 */
public class OssException extends BusinessException{

    /**
     * 连接失败
     */
    public static final int CONNECT_FAILURE = 0;


    public OssException(int errorCode, String message) {
        super(errorCode, message);
    }
}
