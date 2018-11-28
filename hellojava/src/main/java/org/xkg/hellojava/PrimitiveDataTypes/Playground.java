package org.xkg.hellojava.PrimitiveDataTypes;

public class Playground {

    public Playground() {

        boolean bType = true;
        Boolean BType = false;
        System.out.println(BType);

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


        Integer num1 = new Integer(9);
        Integer num2 = new Integer(9);
        Integer num3 = 9;
        Integer num4 = 9;
        int     num5 = 9;
        int     num6 = 9;

        System.out.println(num1.equals(num2));
        System.out.println(num1.equals(num3));
        System.out.println(num1==num2);
        System.out.println(num1==num3);
        System.out.println(num4==num3);

    }
}
