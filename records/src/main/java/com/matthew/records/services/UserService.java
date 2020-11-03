package com.matthew.records.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.records.models.User;
import com.matthew.records.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User findOneUser(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
}
