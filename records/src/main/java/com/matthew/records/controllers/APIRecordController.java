package com.matthew.records.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.records.models.Record;
import com.matthew.records.services.RecordService;

@RestController
@RequestMapping("/api")
public class APIRecordController {
	private RecordService rService;
	
	public APIRecordController(RecordService service) {
		this.rService = service;
	}
	
	
	// Endpoints
	@GetMapping("")
	public List<Record> index(){
		return this.rService.getAllRecords();
	}
	
	@GetMapping("{id}")
	public Record getRecord(@PathVariable("id") Long id) {
		return this.rService.getOneRecord(id);
	}
	
	@RequestMapping(value="/record/update/{id}" )
	@PutMapping("/record/update/{id}")
	public Record edit(@PathVariable("id") Long id, Record updatedRecord) {
		return this.rService.updateRecord(updatedRecord);
	}
	
	@PostMapping("")
	public Record create(Record newRecord) {
		return this.rService.createRecord(newRecord);
	}
	
	@DeleteMapping("/record/delete/{id}")
	public void removeRecord(@PathVariable("id") Long id) {
		this.rService.deleteRecord(id);
	}
}
