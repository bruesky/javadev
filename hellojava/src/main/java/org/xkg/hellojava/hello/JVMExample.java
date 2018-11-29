package org.xkg.hellojava.hello;

/*
* What is JVM
* 1.A specification where working of Java Virtual Machine is specified.
*   But implementation provider is independent to choose the algorithm.
*   Its implementation has been provided by Oracle and other companies.
* 2.An implementation Its implementation is known as JRE (Java Runtime Environment).
* 3.Runtime Instance Whenever you write java command on the command prompt to run the java class,
*   an instance of JVM is created.
*
* */


/*
The JVM performs following operation:

Loads code
Verifies code
Executes code
Provides runtime environment
JVM provides definitions for the:

Memory area
Class file format
Register set
Garbage-collected heap
Fatal error reporting etc.
*/


public class JVMExample {

    public static void main(String[] args)
    {
        System.out.println(args.length);
        // Let's print the classloader name of current class.
        //Application/System classloader will load this class
        Class c=JVMExample.class;
        System.out.println(c.getClassLoader());
        //If we print the classloader name of String, it will print null because it is an
        //in-built class which is found in rt.jar, so it is loaded by Bootstrap classloader
        System.out.println(String.class.getClassLoader());
    }

}

//https://www.javatpoint.com/internal-details-of-jvm