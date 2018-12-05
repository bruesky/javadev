package org.xkg.hellojava.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String args[]){
        TreeSet<String> set=new TreeSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ajay");
        System.out.println("Traversing element through Iterator in descending order");
        Iterator i=set.descendingIterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        TreeSet<Integer> set2=new TreeSet<Integer>();
        set2.add(24);
        set2.add(66);
        set2.add(12);
        set2.add(15);
        System.out.println("Highest Value: "+set2.pollLast());
        System.out.println("Lowest Value: "+set2.pollFirst());
    }
}
