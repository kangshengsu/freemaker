package com.fm.api.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.business.base.constant.CacheKeyConstants;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.core.Context;
import com.fm.framework.web.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 *
 * @ClassName: SSOInterceptor
 * @Description: 登录信息拦截器
 * @author: liuduo8
 * @date:  2020年9月13日11:06:03
 */
@Slf4j
public class SSOInterceptor implements  HandlerInterceptor {

    @Autowired
    private RedissonClient redissonClient;


    /**
     * token key
     */
    private static String TOKEN_KEY = "Admin-Token";
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //统一拦截
        //取出token
        if(readCookieMap(request).get(TOKEN_KEY) != null){

            String token = readCookieMap(request).get(TOKEN_KEY).getValue();
            String cacheKye = String.format(CacheKeyConstants.LOGIN_TOKEN.getKey(),token);
            //获取当前登录token是否有效
            try{
                RBucket<User> currUser = redissonClient.getBucket(cacheKye);
                if(currUser != null && currUser.get() != null){
                    //存入上下文
                    Context.setCurrUser(currUser.get().getId());
                    Context.setCurrUserCode(currUser.get().getCode());
                    Context.setCurrUserName(currUser.get().getName());
                    Context.setCurrUserToken(token);
                    return true;
                }
            }catch (Exception e){
                log.error("获取用户token存活状态异常！",e);
            }

        }

        ResponseUtil.getLoginFailedResponse(response);
        return false;
    }
 
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }
 
    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    /**
     * 获取cookieMap
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {

        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

        Cookie[] cookies = request.getCookies();

        if (null != cookies) {

            for (Cookie cookie : cookies) {

                cookieMap.put(cookie.getName(), cookie);

            }

        }

        return cookieMap;

    }
}