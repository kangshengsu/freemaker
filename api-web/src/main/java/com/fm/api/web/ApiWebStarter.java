package com.fm.api.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Starter
 * @author clufeng
 * @version 1.0.0
 **/
@SpringBootApplication(scanBasePackages = "com.fm")
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.fm")
public class ApiWebStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApiWebStarter.class, args);
    }

}
