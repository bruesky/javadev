package org.xkg.hellojava.collections;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetExample {
    public static void main(String[]args){

        ArrayList<String> list=new ArrayList<String>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");
        HashSet<String> set=new HashSet(list);
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Five");
        set.add("Five");
        set.remove("One");
        HashSet<String> set1=new HashSet<String>();
        set1.add("Ajay");
        set1.add("Gaurav");
        set.addAll(set1);
        Iterator<String> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println("====LinkedHashSet=====");
        LinkedHashSet<String> set2=new LinkedHashSet();
        set2.add("One");
        set2.add("Two");
        set2.add("Three");
        set2.add("Four");
        set2.add("Five");
        set2.add("One");
        Iterator<String> i2=set2.iterator();
        while(i2.hasNext())
        {
            System.out.println(i2.next());
        }
    }
}
