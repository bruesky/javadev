package org.xkg.hellojava.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[]args){
        System.out.println("As List");
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Li");
        ll.add("Wang");
        ll.add("Zhang");

        LinkedList<String> ll2=new LinkedList<String>();
        ll2.add("Sonoo");
        ll2.add("Hanumat");
        ll.addAll(ll2);
        ll.remove("Wang");

        Iterator iterator  = ll.descendingIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("As Stack");
        ll.clear();

        ll.push("Zhao1");
        ll.push("Zhao2");
        ll.push("Zhao3");
        ll.push("Zhao4");
        ll.pop();
        iterator  = ll.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("As Queue");
        ll.clear();
        ll.offer("zhang1");
        ll.offer("zhang2");
        ll.offer("zhang3");
        ll.offer("zhang4");
        ll.poll();
        iterator  = ll.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }

}
