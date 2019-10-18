package edu.mum.finalexam.service;

import edu.mum.finalexam.model.Book;
import edu.mum.finalexam.repository.BookRepository;
import edu.mum.finalexam.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Book addBook(Book book){
        book.setCategory(categoryRepository.findById(book.getCategory().getCatId()).get());
        return bookRepository.save(book);
    }


}
