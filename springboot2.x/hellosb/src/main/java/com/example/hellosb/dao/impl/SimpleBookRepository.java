package com.example.hellosb.dao.impl;

import com.example.hellosb.dao.BookRepository;
import com.example.hellosb.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}