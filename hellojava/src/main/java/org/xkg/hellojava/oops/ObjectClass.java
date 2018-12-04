package org.xkg.hellojava.oops;

/*
* The Object class is the parent class of all the classes in java by default.
*
*
*
* */



public class ObjectClass implements Cloneable {
    public String name = "Bruce";

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[]args) throws IllegalAccessException, InstantiationException, CloneNotSupportedException {
        ObjectClass obj = new ObjectClass();
        ObjectClass obj1=(ObjectClass)obj.clone();
        ObjectClass obj2 = obj.getClass().newInstance();
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());
        System.out.println(obj2.name);

        ObjectClass obj3 = obj;
        obj3.name = "Xiangkui";
        System.out.println(obj.name);

    }
}
