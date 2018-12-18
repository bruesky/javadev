package com.example.hellosb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@RestController
public class MyController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping("/my")
    public String my() {
        return name+" "+age;
    }

}
