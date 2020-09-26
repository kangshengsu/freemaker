package com.fm.api.gw.interceptor;

import com.fm.api.gw.vo.MiniAppUserVO;
import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.core.Context;
import com.fm.framework.web.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        log.info("网关拦截器进入");
        String userToken = request.getHeader("userToken");

        try {
            //存入上下文
            //todo zyc mockData
            RBucket<SysUser> currUser = mockUser("999999");

            if (currUser != null && currUser.get() != null) {
                return true;
            }
        } catch (Exception e) {
            log.error("获取小程序用户信息异常！", e);
        }

        ResponseUtil.getLoginFailedResponse(response);

        return false;
    }

    private RBucket<SysUser> mockUser(String userToken) {
        MiniAppUserVO miniAppUserVO = new MiniAppUserVO();
        miniAppUserVO.setId(1L);
        miniAppUserVO.setFreeLancerId(2L);
        miniAppUserVO.setEmployerId(3L);

        //存入上下文
        Context.setCurrUser(miniAppUserVO.getId());
        Context.setCurrEmployerId(miniAppUserVO.getEmployerId());
        Context.setCurrFreelancerId(miniAppUserVO.getFreeLancerId());

        RBucket<SysUser> currUser = redissonClient.getBucket(userToken);
        currUser.set(miniAppUserVO, 99999, TimeUnit.HOURS);
        return currUser;
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
