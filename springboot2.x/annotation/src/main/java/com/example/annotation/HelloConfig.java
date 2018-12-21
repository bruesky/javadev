package com.example.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
@Configuration
public class HelloConfig {

    @Bean
    Student student(){
        return new Student();
    }
}
