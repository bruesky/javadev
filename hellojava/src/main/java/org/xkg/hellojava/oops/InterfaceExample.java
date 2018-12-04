package org.xkg.hellojava.oops;

/*
* Abstraction shows only essential things to the user and hides the internal details
*
* There are two ways to achieve abstraction in java
* Abstract class (0 to 100%)
* Interface (100%)
*
* */

/*
    An abstract class must be declared with an abstract keyword.
    It can have abstract and non-abstract methods.
    It cannot be instantiated.
    It can have constructors and static methods also.
    It can have final methods which will force the subclass not to change the body of the method.
*/

/*
    An interface in java is a blueprint of a class. It has static constants and abstract methods.
    The interface in Java is a mechanism to achieve abstraction.
    There can be only abstract methods in the Java interface, not method body.
    It is used to achieve abstraction and multiple inheritance in Java.

    Java Interface also represents the IS-A relationship.
    It cannot be instantiated just like the abstract class.
    Since Java 8, we can have default and static methods in an interface.
    Since Java 9, we can have private methods in an interface.
*/


/*
   Abstract class	Interface
1) Abstract class can have abstract and non-abstract methods.
   Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
2) Abstract class doesn't support multiple inheritance.
   Interface supports multiple inheritance.
3) Abstract class can have final, non-final, static and non-static variables.
   Interface has only static and final variables.
4) Abstract class can provide the implementation of interface.
   Interface can't provide the implementation of abstract class.
5) The abstract keyword is used to declare abstract class.
   The interface keyword is used to declare interface.
6) An abstract classcan extend another Java class and implement multiple Java interfaces.
   An interface can extend another Java interface only.
7) An abstract classcan be extended using keyword "extends".
   An interface classcan be implemented using keyword "implements".
8) A Javaabstract classcan have class members like private, protected, etc.
   Members of a Java interface are public by default.
*/


public interface InterfaceExample {
}
