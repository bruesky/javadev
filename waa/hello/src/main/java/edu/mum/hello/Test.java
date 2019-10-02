package edu.mum.hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public void fun(){
        System.out.println("Test Fun");
    }

    public static void main(String[]args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Test.class.getMethod("fun").invoke(new Test());
        System.out.println(Test.class.getMethod("fun") instanceof Method);
        System.out.println(Test.class instanceof Class);
    }
}
