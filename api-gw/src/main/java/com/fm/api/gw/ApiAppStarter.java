package com.fm.api.gw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fm.api.gw"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("HowWorks")
                .description("API文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
