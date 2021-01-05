package com.fm.api.gw.interceptor;

import com.fm.api.gw.vo.MiniAppUserVO;
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
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 小程序登录拦截器
 * 校验用户token是否和缓存token一致，不一致提示用户重新登录
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedissonClient redissonClient;

    private String mockToken = "999999";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String userToken = request.getHeader("userToken");
        Boolean isNeedValid = Boolean.valueOf(request.getHeader("isNeedValid"));
        if (!isNeedValid) {
            return true;
        }
        log.info("小程序网关拦截器进入，token：{}", userToken);
        log.info("小程序拦截路径: {}",request.getRequestURI());
        //region todo zyc mockData to be delete
//        this.fillMockUser();
//        userToken = mockToken;
        //endregion

        RBucket<MiniAppUserVO> rBucket = redissonClient.getBucket(userToken);

        //存入上下文
        return Optional.ofNullable(rBucket)
                .map(bucket -> bucket.get())
                .map(currUser -> {
                    Context.setCurrUser(currUser.getUserId());
                    Context.setCurrEmployerId(currUser.getEmployerId());
                    Context.setCurrFreelancerId(currUser.getFreeLancerId());
                    Context.setMiniAppSecretKey(currUser.getSessionKey());
                    Context.setCurrUserCode(currUser.getOpenId());
                    return true;
                })
                .orElseGet(() -> {
                    ResponseUtil.getLoginFailedResponse(response);
                    return false;
                });
    }

    @Deprecated
    private RBucket<MiniAppUserVO> fillMockUser() {
        MiniAppUserVO miniAppUserVO = new MiniAppUserVO();
        miniAppUserVO.setUserId(8105L);
        miniAppUserVO.setFreeLancerId(8105L);
        miniAppUserVO.setEmployerId(8105L);
        miniAppUserVO.setOpenId("o9kHZ5eoze26LM5wuw8uAAov-uQA");

        RBucket<MiniAppUserVO> currUser = redissonClient.getBucket(mockToken);
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