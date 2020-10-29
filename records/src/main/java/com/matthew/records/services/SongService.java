package com.matthew.records.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.records.models.Song;
import com.matthew.records.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	
	public Song create(Song song) {
		return this.sRepo.save(song);
	}
}
