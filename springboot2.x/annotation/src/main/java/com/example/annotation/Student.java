package com.example.annotation;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class Student {
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

    @Pointcut()
    public String atSchool(){
        if(age<18){
            throw new ArithmeticException("Not valid age");
        }
        else{
            System.out.println("Thanks for vote");
        }
        System.out.println("at school");
        return "atSchool";
    }

}
