package com.matthew.weddings.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.weddings.models.User;
import com.matthew.weddings.models.Wedding;
import com.matthew.weddings.repositories.WeddingRepository;

@Service
public class WeddingService {
	@Autowired
	private WeddingRepository wRepo;
	
	
	// List All Weddings
	public List<Wedding> getWeddings(){
		return this.wRepo.findAll();
	}
	// Get Single Wedding
	public Wedding getById(Long id) {
		return this.wRepo.findById(id).orElse(null);
	}
	
	// Create New Wedding
	public Wedding create(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
	
	// Update Wedding
	public Wedding update(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
	
	// RSVP To Wedding
	public void addAttendee(User user, Wedding wedding) {
		List<User> attendees = wedding.getGuests();
		// Add the User to the Wedding Guests
		attendees.add(user);
		//Update
		this.wRepo.save(wedding);
	}
	
	// Un RSVP to Wedding
	public void removeAttendee(User user, Wedding wedding) {
		List<User> attendees = wedding.getGuests();
		// Add the User to the Wedding Guests
		attendees.remove(user);
		//Update
		this.wRepo.save(wedding);
	}
	
	// Delete Wedding
	public void deleteWedding(Wedding wedding) {
		this.wRepo.delete(wedding);
	}
}
