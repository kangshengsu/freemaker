package com.fm.api.gw.config;


import com.fm.api.gw.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 登录拦截器配置
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor ssoInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(ssoInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns(
                "/v1/miniApp/syncUserInfo",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/swagger-resources/configuration/security",
                "/v2/api-docs",
                "/**/*.html",
                "/**/*.js",
                "/**/*.css",
                "/**/*.woff",
                "/**/*.ttf"
        );
    }
}