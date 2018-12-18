package com.example.hellosb.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@Configuration
@PropertySource(value = "classpath:info.properties")
@ConfigurationProperties(prefix = "com.test")
public class InfoBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
