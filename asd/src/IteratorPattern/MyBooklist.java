package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyBooklist implements Booklist {
    private List<String> books;

    public MyBooklist() {
        this.books = new ArrayList<>();
    }

    void addBook(String book){
        books.add(book);
    }

    @Override
    public Iterator getIterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator{
        private  int index;
        @Override
        public boolean hasNext() {
            return index<books.size();
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return books.get(index++);
            }
            return null;
        }
    }

}
