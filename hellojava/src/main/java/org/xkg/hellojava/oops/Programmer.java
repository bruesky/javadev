package org.xkg.hellojava.oops;



/*
* The idea behind inheritance in Java is that you can create new classes that are built upon existing classes.
* When you inherit from an existing class, you can reuse methods and fields of the parent class.
* Moreover, you can add new methods and fields in your current class also.
* Inheritance is to reuse the fields and methods of the existing class when you create a new class.
* For Method Overriding (so runtime polymorphism can be achieved).
* For Code Reusability.
*
* Inheritance represents the IS-A relationship which is also known as a parent-child relationship.
* Aggregation represents HAS-A relationship.For Code Reusability.
* */

public class Programmer extends Employee {
    int bonus;
    {bonus=100;}//Instance Initializer block is used to initialize the instance data member.
                // It run each time when object of the class is created.
                //The instance initializer block is created when instance of the class is created.
                //The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
                //The instance initializer block comes in the order in which they appear.

    /*
    * Method Overloading
    * If a class has multiple methods having same name but different in parameters, it is known as Method Overloading.
    *
    * By changing number of arguments
    * By changing the data type
    * In java, method overloading is not possible by changing the return type of the method only because of ambiguity.
    * You can have any number of main methods in a class by method overloading. But JVM calls main() method which receives string array as arguments only.
    *
    *
    *
    * */

    static int add(int a,int b){return a+b;}
    static int add(int a,int b,int c){return a+b+c;}
    static double add(double a, double b){return a+b;}

    /*
    * method overriding
    * If subclass (child class) has the same method as declared in the parent class, it is known as method overriding in Java.
    * Method overriding is used to provide the specific implementation of a method which is already provided by its superclass.
    * Method overriding is used for runtime polymorphism
    *
    * The method must have the same name as in the parent class
    * The method must have the same parameter as in the parent class.
    * There must be an IS-A relationship (inheritance).
    *
    * */


    /*
    super can be used to refer immediate parent class instance variable.
    super can be used to invoke immediate parent class method.
    super() can be used to invoke immediate parent class constructor.
    */


    public static void main(String args[]){
        Programmer p=new Programmer();
        System.out.println("Programmer salary is:"+p.salary);
        System.out.println("Bonus of Programmer is:"+p.bonus);
    }
}
