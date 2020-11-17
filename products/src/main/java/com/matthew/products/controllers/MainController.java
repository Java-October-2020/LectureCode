package com.matthew.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.matthew.products.models.Category;
import com.matthew.products.models.Product;
import com.matthew.products.services.CategoryService;
import com.matthew.products.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	
	
	@GetMapping("/products/new")
	public String newProd(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}

	
	@GetMapping("/category/new")
	public String newCat(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}
		pService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@PostMapping("/category/new")
	public String addCat(@Valid @ModelAttribute("Category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}
		this.cService.createCat(category);
		return "redirect:/category/new";
	}
	
	@GetMapping("/product/{id}")
	public String showProd(@PathVariable("id") Long id, Model viewModel) {
		Product product = this.pService.findById(id);
		viewModel.addAttribute("product", product);
		List<Category> unqiueCats = this.cService.catsNotAdded(product);
		viewModel.addAttribute("uniqueCats", unqiueCats);
		List<Category> categories = product.getCategories();
		return "/products/show.jsp";
	}
	
	@GetMapping("/category/{id}")
	public String showCat(@PathVariable("id") Long id, Model viewModel) {
		Category category = this.cService.findById(id);
		List<Product> products = category.getProducts();
		viewModel.addAttribute("category", category);
		viewModel.addAttribute("products", products);
		List<Product> unAdded = this.pService.getUniqueCats(category);
		viewModel.addAttribute("unAdded", unAdded);
		return "/categories/show.jsp";
	}
	
	
	
}
