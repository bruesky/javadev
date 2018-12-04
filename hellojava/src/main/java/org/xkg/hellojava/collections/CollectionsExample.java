package org.xkg.hellojava.collections;


import java.util.ArrayList;
import java.util.Iterator;

/*
The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:
    Interfaces and its implementations, i.e., classes
    Algorithm
*/
public class CollectionsExample {

    public static void main(String[]args){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
//Traversing list through Iterator
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
