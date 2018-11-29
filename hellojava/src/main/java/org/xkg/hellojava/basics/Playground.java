package org.xkg.hellojava.basics;

/*
* 8 primitive data types
* */

import com.sun.tools.internal.jxc.gen.config.Classes;

public class Playground {

    //    There are three types of variables in java: local, instance and static.
    //    There are two types of data types in java: primitive and non-primitive.

    int data=50;//instance variable
    static int m=100;//static variable
    void method(){
        System.out.println("method");
        int n=90;//local variable

        int a=10;
        float f=a; //Widening
        System.out.println(a);
        System.out.println(f);

        float f1=10.5f;//Narrowing (Typecasting)
        //int a=f;//Compile time error
        int a1=(int)f1;
        System.out.println(f1);
        System.out.println(a1);

        //Overflow
        int a2=130;
        byte b=(byte)a2;
        System.out.println(a2);
        System.out.println(b);


        byte a5=10;//Widening
        byte b5=10;
        //byte c5=a5+b5;//Compile Time Error: because a5+b5=20 will be int
        byte c5=(byte)(a5+b5);
        System.out.println(c5);

        System.out.println(-20>>>2);
    }

    // Primitive data types: The primitive data types include boolean, char, byte, short, int, long, float and double.
    // Non-primitive data types: The non-primitive data types include Classes, Interfaces, String and Arrays.

    public Playground() {

        System.out.println("Playground");
        //The Boolean data type is used to store only two possible values: true and false.
        // This data type is used for simple flags that track true/false conditions.
        //The Boolean data type specifies one bit of information, but its "size" can't be defined precisely.
        boolean bType = true;
        Boolean BType = false;
        System.out.println(BType);

        //The char data type is a single 16-bit Unicode character.
        // Its value-range lies between '\u0000' (or 0) to '\uffff' (or 65,535 inclusive).
        // The char data type is used to store characters.
        // Java uses Unicode system not ASCII code system. The \u0000 is the lowest range of Unicode system.

        char cType = new Character('G');
        Character CType = cType;
        System.out.println(CType+" "+Character.SIZE+" Bits ");

        Byte byteType = 10;
        System.out.println("Byte "+Byte.SIZE+" Bits "+Byte.MIN_VALUE+" "+Byte.MAX_VALUE);

        Short shortType = 12;
        System.out.println("Short "+Short.SIZE+" Bits "+Short.MIN_VALUE+" "+Short.MAX_VALUE);
        System.out.println("Integer "+Integer.SIZE+" Bits "+Integer.MIN_VALUE+" "+Integer.MAX_VALUE);
        System.out.println("Long "+Long.SIZE+" Bits "+Long.MIN_VALUE+" "+Long.MAX_VALUE);

        float fType = 1.345f;
        System.out.println("Float "+Float.SIZE+" Bits "+Float.MIN_VALUE+" "+Float.MAX_VALUE);
        double dType = 2.34d;
        System.out.println("Double "+Double.SIZE+" Bits "+Double.MIN_VALUE+" "+Double.MAX_VALUE);

        /* Autoboxing and unboxing cache
        *  https://www.cnblogs.com/wang-yaz/p/8516151.html
        * */
        Integer num1 = new Integer(9);
        Integer num2 = new Integer(9);

        System.out.println(num1==num2);

        Integer num3 = Integer.valueOf(1000);//No Cache
        Integer num4 = Integer.valueOf(10);//Cache -128~127

        System.out.println(num3==num4);

        Integer num5 = 1000;//Integer.valueOf(1000)
        System.out.println(num3==num5);

        int     num6 = num5;
        System.out.println(num3==num6);//unboxing
        System.out.println(num3.equals(num6));
        System.out.println(num3.equals(num5));

        method();
    }
}
