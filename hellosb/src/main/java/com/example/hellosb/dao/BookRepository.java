package com.example.hellosb.dao;

import com.example.hellosb.entity.Book;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
