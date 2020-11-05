package com.matthew.records.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	
	public User registerUser(User newUser) {
		// Generate A Hash
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// Set The Hashed Password on the users password field
		newUser.setPassword(hash);
		// Save that new user with the updated password to the database
		return this.uRepo.save(newUser);
	}
	
	// Authenticate User
	public boolean authenicateUser(String email, String password) {
		// make sure the user logging in is who they say they are
		// Step 1: Try and query for user by email
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		//Step 2: check provided email against email in our database for the user
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
