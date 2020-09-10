package com.fm.framework.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;


@Slf4j
@Configuration
@SpringBootApplication(scanBasePackages = {"com.fm.framework"})
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.fm.framework")
public class FrameworkApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class, args);
    }
}
