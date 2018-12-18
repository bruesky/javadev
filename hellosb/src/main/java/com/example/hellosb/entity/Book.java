package com.example.hellosb.entity;

import java.io.Serializable;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
public class Book implements Serializable {

    private String isbn;
    private String title;

    public Book(String isbn, String some_book) {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
