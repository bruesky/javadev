package com.example.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
@Aspect
@Component
public class StudentAspect {

    @Pointcut("execution(* com.example.annotation.Student.atSchool(..))")
    public void k(){}//pointcut name

    @Before("k()")
    public void gotoSchool(){
        System.out.println("goto school");
    }

    @After("k()")
    public void afterSchool(){
        System.out.println("after school");
    }

    @AfterReturning(
            pointcut = "k()",
            returning= "result")

    public void myadvice(JoinPoint jp,Object result)//it is advice (after returning advice)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Result in advice: "+result);
        System.out.println("end of after returning advice...");
    }

    @Around("k()")
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Additional Concern Before calling actual method");
        Object obj=pjp.proceed();
        System.out.println("Additional Concern After calling actual method");
        return obj;
    }

    @AfterThrowing(
            pointcut = "k()",
            throwing= "error")
    public void myadvice(JoinPoint jp,Throwable error)//it is advice
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }
}
