package edu.mum.finalexam.service;

import edu.mum.finalexam.model.Book;
import edu.mum.finalexam.model.Category;
import edu.mum.finalexam.repository.BookRepository;
import edu.mum.finalexam.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void crub(){
        Optional<Category> category =  categoryRepository.findById(1l);
        System.out.println(category.get().getBooks());
        Book book = new Book();
        book.setBookName("Master Maharishi");
        book.setCategory(category.get());
        Book book1 = bookRepository.save(book);
        category =  categoryRepository.findById(1l);
        System.out.println(category.get());
        System.out.println(bookRepository.findAll());
        System.out.println(categoryRepository.findAll());
        book1.setBookName("English Book");
        bookRepository.save(book1);
        System.out.println(bookRepository.findAll());
        bookRepository.delete(book1);
        System.out.println(bookRepository.findAll());
        category =  categoryRepository.findById(1l);
        System.out.println(category.get());
        System.out.println(category.isPresent());
        categoryRepository.delete(category.get());
        System.out.println(bookRepository.findAll());
        category =  categoryRepository.findById(1l);
        System.out.println(category.isPresent());

    }
}