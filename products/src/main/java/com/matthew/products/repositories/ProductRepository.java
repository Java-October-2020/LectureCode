package com.matthew.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.products.models.Category;
import com.matthew.products.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll(); // SELECT * FROM Products
	List<Product> findByCategoriesNotContains(Category category);
}
