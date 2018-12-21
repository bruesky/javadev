package com.example.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
@RequestMapping("/")
@RestController
public class HelloController {

    @Autowired
    private Student student;

    @RequestMapping("/hello")
    String hello(){
        student.setName("Xxxx");
        student.setAge(19);
        student.atSchool();
        return "hello anno "+ student.getName()+" "+student.getAge();
    }
}
