package com.xxb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/4 11:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${server.api.path}")
    private String pathMapping;

    @Value("${swagger.enable}")
    private Boolean enableSwagger;

    // Swagger 容器初始化配置
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.xxb.web.controller")).paths(PathSelectors.any()).build()
                .enable(enableSwagger);
    }

    // 文档信息描述
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("App项目管理系统").description("接口文档")
                .termsOfServiceUrl("").license("Version 1.0").licenseUrl("#")
                .version("1.0").build();
    }

}
