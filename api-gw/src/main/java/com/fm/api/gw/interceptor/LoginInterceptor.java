package com.fm.api.gw.interceptor;

import com.fm.business.base.constant.CacheKeyConstants;
import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.core.Context;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String cacheKey = request.getParameter("openId");

        try {
            RBucket<SysUser> currUser = redissonClient.getBucket(cacheKey);

//            if (currUser != null && currUser.get() != null) {
//                //存入上下文
//                Context.setCurrUser(currUser.get().getId());
//                Context.setCurrUserCode(currUser.get().getCode());
//                Context.setCurrUserName(currUser.get().getName());
//                return true;
//            }
        } catch (Exception e) {
            log.error("获取小程序用户信息异常！", e);
        }

        return true;
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
}
