package com.matthew.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.products.models.Category;
import com.matthew.products.models.Product;
import com.matthew.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	// Get All
	public List<Category> getAllCategories(){
		return this.cRepo.findAll();
	}
	
	// Get One
	public Category findById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	// Create
	public Category createCat(Category category) {
		return this.cRepo.save(category);
	}
	
	// Update a Category
	public Category updateCat(Category category) {
		return this.cRepo.save(category);
	}
	
	public List<Category> catsNotAdded(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
}
