package com.matthew.records.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.records.models.Label;
import com.matthew.records.repositories.LabelRepository;

@Service
public class LabelService {
	@Autowired
	private LabelRepository lRepo;
	
	//Create
	public Label create(Label label) {
		return this.lRepo.save(label);
	}
}
