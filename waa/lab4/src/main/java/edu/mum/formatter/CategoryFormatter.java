package edu.mum.formatter;

import edu.mum.domain.Category;
import edu.mum.service.CategoryService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    @Autowired
    CategoryService categoryService;

    @Override
    public Category parse(String s, Locale locale) throws ParseException {
        int id = Integer.parseInt(s);
        return categoryService.getCategory(id);
    }

    @Override
    public String print(Category category, Locale locale) {
        return  category.getName();
    }
}
