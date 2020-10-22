package com.matthew.records.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.records.models.Record;
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
	
	public Record createRecord(String name, String album, int year) {
		Record newRecord = new Record(name, album, year);
		return this.rRepo.save(newRecord);
	}
	
	// Update Record
	public Record updateRecord(Record updatedRecord) {
		return this.rRepo.save(updatedRecord);
	}
	
	// Delete Record
	public String deleteRecord(Long id) {
		this.rRepo.deleteById(id);
		return "Record " + id + " has been deleted";
	}
}
