package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;

@Controller
public class ProductController {
 
	ProductService productService;
 	
	CategoryService categoryService;
	
	ProductController() {
		
	}
 	
	// Setter based injection....
	@Autowired
	ProductController(ProductService productService,CategoryService categoryService) {
		this.categoryService =  categoryService;
		this.productService = productService;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryService.getAll();
	}

	@ModelAttribute("products")
	public List<Product> getproducts(){
		return productService.getAll();
	}
 	
    @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
    public String inputProduct(@ModelAttribute("product") Product product, Model model) {
        return "ProductForm";
    }


	@RequestMapping(value="/product", method = RequestMethod.POST)
     public String saveProduct(@ModelAttribute("product") Product product,BindingResult result,@RequestBody String bb) {
    	productService.save(product);
        return "ProductDetails";
    }
    
    
    @RequestMapping(value="/listproducts")
    public String listProducts(@ModelAttribute("product") Product product) {
        return "ListProducts";
    }

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "name", "category", "price", "description");
	}
}
