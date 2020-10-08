package com.fm.framework.web.controller;

import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.web.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;


/**
 * 统一异常处理
 * @author clufeng
 * @version 1.0.0
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ApiResponse<?> handleConstraintViolationException(ConstraintViolationException ex) {
        return ApiResponse.ofFailed(ex.getMessage());
    }

    @ExceptionHandler
    public ApiResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder errorMsg = new StringBuilder();
        BindingResult re = ex.getBindingResult();
        for (ObjectError error : re.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return ApiResponse.ofFailed(errorMsg.toString());
    }


    @ExceptionHandler
    public ApiResponse<?> handleBindException(BindException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return ApiResponse.ofFailed(errorMsg.toString());
    }


    @ExceptionHandler
    public ApiResponse<?> handleBusinessException(BusinessException e) {
        log.error("[errorCode:{}, errorMsg:{}], e: {}", e.getErrorCode(), e.getMessage(), e);
        return ApiResponse.ofFailed(e.getMessage());
    }

    @ExceptionHandler
    public ApiResponse<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.ofFailed("系统开小差~~~");
    }

}
