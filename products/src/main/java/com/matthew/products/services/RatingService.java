package com.matthew.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.products.models.Rating;
import com.matthew.products.repositories.ProductRepository;
import com.matthew.products.repositories.RatingRepository;
import com.matthew.products.repositories.UserRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository rRepo;
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private UserRepository uRepo;
	
	// Add Rating To Product
	public void createRating(Rating rating) {
		
		this.rRepo.save(rating);
	}
	
	
	
	
}
