package org.xkg.hellojava.collections;


import java.util.*;

/*
The Collection framework represents a unified architecture for storing and manipulating a group of objects. It has:
    Interfaces and its implementations, i.e., classes
    Algorithm
*/
public class CollectionsExample {

    public static void main(String[]args){

        System.out.println("====ArrayList====");
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
//Traversing list through Iterator
        list.remove(new String("Ravi"));
        Iterator<String> itr=list.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("====LinkedList====");
        LinkedList<String> al=new LinkedList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        al.remove();
        al.remove(2);
        itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("====Vector====");

        Vector<String> v=new Vector<String>();
        v.add("Ayush");
        v.add("Amit");
        v.add("Ashish");
        v.add("Garima");
        itr=v.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("====Stack====");
        Stack<String> stack = new Stack<String>();
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashish");
        stack.push("Garima");
        stack.pop();
        itr=stack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("====PriorityQueue====");
        PriorityQueue<Integer> qInt = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*(-1);
            }
        });

        for (int i = 0; i < 100; i++) {
            qInt.add((int)(Math.random()*100));
        }

        while(!qInt.isEmpty()){
            System.out.println(qInt.poll());
        }



        PriorityQueue<String> queue=new PriorityQueue<String>(11, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        queue.add("Amit Sharma");
        queue.add("Vijay Raj");
        queue.add("JaiShankar");
        queue.add("Raj");
        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());
        System.out.println("iterating the queue elements:");
        itr=queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        queue.remove();
        queue.poll();
        System.out.println("after removing two elements:");
        Iterator<String> itr2=queue.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        System.out.println("====Deque====");
        //Creating Deque and adding elements
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Gautam");
        deque.add("Karan");
        deque.add("Ajay");
        deque.pollFirst();
        deque.addFirst("666");
        //Traversing elements
        for (String str : deque) {
            System.out.println(str);
        }

        System.out.println("====HashSet====");
        //Creating HashSet and adding elements
        HashSet<String> set=new HashSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        //Traversing elements
        itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("====LinkedHashSet====");
        LinkedHashSet<String> set2=new LinkedHashSet<String>();
        set2.add("Ravi");
        set2.add("Vijay");
        set2.add("Ravi");
        set2.add("Ajay");
        itr=set2.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("====TreeSet====");
        //Creating and adding elements
        TreeSet<String> set3=new TreeSet<String>();
        set3.add("Ravi");
        set3.add("Vijay");
        set3.add("Ravi");
        set3.add("Ajay");
        //traversing elements
        itr=set3.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }

}
