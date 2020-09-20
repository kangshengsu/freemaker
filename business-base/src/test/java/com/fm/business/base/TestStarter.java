package com.fm.business.base;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * 测试启动类
 * @author hubo
 * @version 1.0.0
 **/
@SpringBootApplication(scanBasePackages = "com.fm")
@MapperScan("com.fm.**.dao")
@EnableCaching
public class TestStarter {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
