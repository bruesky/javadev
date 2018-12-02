package org.xkg.hellojava.test;

import org.xkg.hellojava.oops.Student;

public class Test {

    public static void main(String[]args){
//Creating an object or instance
        Student s1=new Student();//creating an object of Student
        //Printing values of the object
        System.out.println(s1.getId());//accessing member through reference variable
        System.out.println(s1.getName());    }
}
