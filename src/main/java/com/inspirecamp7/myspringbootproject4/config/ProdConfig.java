package com.inspirecamp7.myspringbootproject4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//지금은 @Profile 으로 설정을 안해서 오류가 발생할것이다. -> 메서드 명이 bean의 id가 되는데 customVO()가 2개 있어서 오류남
@Configuration
public class ProdConfig {
    @Bean
    public CustomVO customVO() {
        return CustomVO.builder()
                .mode("PROD MODE")
                .rate(1.9)
                .build();
    }
}
