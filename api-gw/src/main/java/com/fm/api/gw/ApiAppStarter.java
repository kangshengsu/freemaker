package com.fm.api.gw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Starter
 * @author clufeng
 * @version 1.0.0
 **/
@SpringBootApplication(scanBasePackages = "com.fm")
@MapperScan("com.fm.**.dao")
@EnableCaching
public class ApiAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApiAppStarter.class, args);
    }

}
