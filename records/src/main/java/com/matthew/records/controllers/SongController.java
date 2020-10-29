package com.matthew.records.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.records.models.Song;
import com.matthew.records.services.RecordService;
import com.matthew.records.services.SongService;

@Controller
@RequestMapping("/songs")
public class SongController {
	@Autowired
	private SongService sService;
	@Autowired
	private RecordService rService;
	
	@GetMapping("/new")
	public String createSong(@ModelAttribute("song") Song song, Model viewModel) {
		viewModel.addAttribute("records", this.rService.getAllRecords());
		return "songs/new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("song") Song newSong, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("records", this.rService.getAllRecords());
			return "songs/new.jsp";
		} else {
			this.sService.create(newSong);
			return "redirect:/";
		}
	}
	
}
