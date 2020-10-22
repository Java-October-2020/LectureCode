package com.matthew.records.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.records.models.Record;
import com.matthew.records.services.RecordService;

@Controller
public class HomeController {
	@Autowired
	private RecordService rService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Record> records = this.rService.getAllRecords();
		viewModel.addAttribute("allRecords", records);
		return "index.jsp";
	}
	
	
	//Non JPA Way
	@PostMapping("/addOldWay")
	public String addAlbum(@RequestParam("artistName") String name, @RequestParam("albumName") String album, @RequestParam("year") int year, RedirectAttributes redirectAttrs) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey there, you forgot to add an artist name");
		}
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttrs.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		
		this.rService.createRecord(name, album, year);
		return "redirect:/";
	}
	
	@PostMapping("/add")
	public String addNewAlbum(@Valid @ModelAttribute("record") Record newRecord, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			this.rService.createRecord(newRecord);
			return "redirect:/";
		}
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("record") Record record) {
		return "add.jsp";
	}
}
