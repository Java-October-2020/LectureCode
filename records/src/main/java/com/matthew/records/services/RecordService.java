package com.matthew.records.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.records.models.Record;
import com.matthew.records.models.User;
import com.matthew.records.repositories.RecordRepository;

@Service
public class RecordService {
	private RecordRepository rRepo;
	
	public RecordService(RecordRepository repo) {
		this.rRepo = repo;
	}
	
	// Get All
	public List<Record> getAllRecords(){
		return this.rRepo.findAll();
	}
	
	// Get One (Read)
	public Record getOneRecord(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	
	// Create Record
	public Record createRecord(Record newRecord) {
		return this.rRepo.save(newRecord);
	}
	
	
	// Update Record
	public Record updateRecord(Record updatedRecord) {
		return this.rRepo.save(updatedRecord);
	}
	
	// Delete Record
	public void deleteRecord(Long id) {
		this.rRepo.deleteById(id);
	}
	
	//Add User Who Likes The Record
	public void addLiker(User user, Record record) {
		//Get the list of likers from the record
		List<User> likers = record.getLikers();
		// Add The Liker
		likers.add(user);
		// Update DB
		this.rRepo.save(record);
	}
	
	public void removeLiker(User user, Record record) {
		//Get the list of likers from the record
		List<User> likers = record.getLikers();
		// Remove the liker
		likers.remove(user);
		// Update DB
		this.rRepo.save(record);
	}
}
