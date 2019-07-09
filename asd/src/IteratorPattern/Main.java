package IteratorPattern;

import java.util.Iterator;

public class Main {
    public static void main(String[]args){
        MyBooklist booklist = new MyBooklist();
        booklist.addBook("C");
        booklist.addBook("A");
        booklist.addBook("B");
        Iterator iterator = booklist.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
