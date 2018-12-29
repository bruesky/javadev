package org.xkg.hellojava.java8;

import java.lang.String;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */
public class LambdaExpressionsExample {

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    public static void main(String[]args){
        GreetingService greetingService =  (String message) -> System.out.println("Hello " + message);
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println(addition.operation(3,5));
        greetingService.sayMessage("Xxxxx");
    }

}
