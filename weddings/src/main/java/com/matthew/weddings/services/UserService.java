package com.matthew.weddings.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.weddings.models.User;
import com.matthew.weddings.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User find(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
	
	public User registerUser(User newUser) {
		// Generate Hash
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// Set the hashed password on the User's password field
		newUser.setPassword(hash);
		//Save the new owner with the salted password to the database
		return this.uRepo.save(newUser);
	}
	
	//Login Authentication
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is who they say they are
		//step 1: try and query
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		
		//Step 2 check provided email aginst email in the database for User
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
