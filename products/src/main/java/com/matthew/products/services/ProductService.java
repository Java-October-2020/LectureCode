package com.matthew.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.products.models.Category;
import com.matthew.products.models.Product;
import com.matthew.products.repositories.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;;
	
	// Get All
	public List<Product> getAllProduct(){
		return this.pRepo.findAll();
	}
	
	// Get One
	public Product findById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	// Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	// Update a Category
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	// Get Unique Categories
	public List<Product> getUniqueCats(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	// Add Product To Category
	public void addProductToCat(Product product, Category category) {
		// Get The List From the Product Object
		List<Category> cats = product.getCategories();
		// Add The Category
		cats.add(category);
		// Update
		this.pRepo.save(product);
	}
	

	
}
