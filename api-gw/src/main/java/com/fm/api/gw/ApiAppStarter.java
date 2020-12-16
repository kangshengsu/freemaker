package com.fm.api.gw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Starter
 * @author clufeng
 * @version 1.0.0
 **/
@SpringBootApplication(scanBasePackages = "com.fm")
@MapperScan("com.fm.**.dao")
@EnableCaching
@EnableSwagger2
public class ApiAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApiAppStarter.class, args);
    }
}
