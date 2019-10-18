package edu.mum.finalexam.service;

import edu.mum.finalexam.model.Category;
import edu.mum.finalexam.repository.BookRepository;
import edu.mum.finalexam.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }


}
