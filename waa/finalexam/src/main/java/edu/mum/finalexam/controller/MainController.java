package edu.mum.finalexam.controller;

import edu.mum.finalexam.model.Book;
import edu.mum.finalexam.model.Category;
import edu.mum.finalexam.repository.BookRepository;
import edu.mum.finalexam.repository.CategoryRepository;
import edu.mum.finalexam.service.BookService;
import edu.mum.finalexam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @GetMapping({"/","/hello"})
    public String hello(Model model){
        model.addAttribute("hello","hello there!!!");
        return "hello";
    }

    @GetMapping({"/book"})
    public String book(@ModelAttribute("book") Book book, Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "bookform";
    }

    @PostMapping({"/book"})
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAll());
            return "bookform";
        }else {
            redirectAttributes.addFlashAttribute("book",bookService.addBook(book));
            return "redirect:/sucess";
        }
    }

    @GetMapping("/sucess")
    public String sucess(){
        return "sucess";
    }

}
