package com.fm.framework.web.utils;

import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {

    /**
     * 以JSON格式输出
     * @param response
     */
    public static void getLoginFailedResponse(HttpServletResponse response) {
        //将实体对象转换为JSON Object转换
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JsonUtil.obj2String(
                    ApiResponse.of(ApiStatus.LOGIN_NOT_FOUND.getCode(),ApiStatus.LOGIN_NOT_FOUND.getMessage(),null)));
        } catch (IOException e) {
            log.error("SSOInterceptor getLoginFailedResponse error!",e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
