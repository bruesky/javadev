package org.xkg.hellojava.hello;


/*
* Java is a programming language and a platform.
* Java is a high level, robust, class-based, concurrent, object-oriented and secure programming language.
* Platform: Any hardware or software environment in which a program runs, is known as a platform.
* Since Java has a runtime environment (JRE) and API, it is called a platform.
* */

/*
*  JVM (Java Virtual Machine) is an abstract machine.It is a specification that provides a runtime environment in which Java bytecode can be executed.
*  It can also run those programs which are written in other languages and compiled to Java bytecode.
*
*  JRE is the implementation of JVM. It physically exists. It contains a set of libraries + other files that JVM uses at runtime.
*
*  JDK contains a private Java Virtual Machine (JVM) and a few other resources such as an interpreter/loader (java),
*  a compiler (javac), an archiver (jar), a documentation generator (Javadoc), etc. to complete the development of a Java Application.
*
*  JVM, JRE, and JDK are platform dependent because the configuration of each OS is different from each other.
*  Java is platform independent.
*
* */


/*
1.class keyword is used to declare a class in java.
2.public keyword is an access modifier which represents visibility. It means it is visible to all.
3.static is a keyword. If we declare any method as static, it is known as the static method.
The core advantage of the static method is that there is no need to create an object to invoke the static method.
The main method is executed by the JVM, so it doesn't require to create an object to invoke the main method. So it saves memory.
4.void is the return type of the method. It means it doesn't return any value.
5.main represents the starting point of the program.
6.String[] args is used for command line argument. We will learn it later.
7.System.out.println() is used to print statement. Here, System is a class, out is the object of PrintStream class, println() is the method of PrintStream class.
*/


public class HelloWorld {
    public static void main(String[]args){
        System.out.println("Hello World!");
    }
}
