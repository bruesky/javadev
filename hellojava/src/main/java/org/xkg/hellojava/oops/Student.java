package org.xkg.hellojava.oops;

//Java Program to illustrate how to define a class and fields
//Defining a Student class.
public class Student{
    //defining fields
    private int id;//field or data member or instance variable
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //creating main method inside the Student class
    public static void main(String args[]){

    }
}