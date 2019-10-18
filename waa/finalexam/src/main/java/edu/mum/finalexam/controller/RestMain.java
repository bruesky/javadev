package edu.mum.finalexam.controller;

import edu.mum.finalexam.model.Book;
import edu.mum.finalexam.service.BookService;
import edu.mum.finalexam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestMain {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public Book addBook(@Valid @RequestBody Book book){
        System.out.println(book);
        return bookService.addBook(book);
    }
}
