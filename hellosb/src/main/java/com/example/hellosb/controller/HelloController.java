package com.example.hellosb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@RestController
public class HelloController
{
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
