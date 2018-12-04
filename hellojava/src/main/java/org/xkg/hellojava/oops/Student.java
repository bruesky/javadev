package org.xkg.hellojava.oops;

//Java Program to illustrate how to define a class and fields
//Defining a Student class.
public class Student{
    //defining fields
    private int id;//field or data member or instance variable
    private String name;


    /* Constructor is a block of codes similar to the method. It is called when an instance of the object is created
    *  It is a special type of method which is used to initialize the object.
    *  It is called constructor because it constructs the values at the time of object creation.
    *  It is not necessary to write a constructor for a class.
    *  It is because java compiler creates a default constructor if your class doesn't have any.
    *
    *  Constructor name must be the same as its class name
    *  A Constructor must have no explicit return type
    *  A Java constructor cannot be abstract, static, final, and synchronized
    *
    *  Default constructor (no-arg constructor)
    *  Parameterized constructor
    *
    * */


    /*
    * The static keyword in Java is used for memory management mainly.
    * We can apply java static keyword with variables, methods, blocks and nested class.
    * The static keyword belongs to the class than an instance of the class.
    *
    * Variable (also known as a class variable)
    * Method (also known as a class method)
    * Block
    * Nested class
    * */

    /*
    *
    * this can be used to refer current class instance variable.
    * this can be used to invoke current class method (implicitly)
    * this() can be used to invoke current class constructor.
    * this can be passed as an argument in the method call.
    * this can be passed as argument in the constructor call.
    * this can be used to return the current class instance from the method.
    *
    * */

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