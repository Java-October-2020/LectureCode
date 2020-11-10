package com.matthew.weddings.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.weddings.models.User;
import com.matthew.weddings.models.Wedding;
import com.matthew.weddings.services.UserService;
import com.matthew.weddings.services.WeddingService;

@Controller
@RequestMapping("/wedding")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	
	@GetMapping("")
	public String weddingsIndex(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.find(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		
		return "weddings/dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newWedding(@ModelAttribute("wedding") Wedding wedding, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		return "/weddings/new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("wedding") Wedding wedding, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("userId");
			viewModel.addAttribute("user_id", userId);
			return "/weddings/new.jsp";
		}
		this.wService.create(wedding);
		return "redirect:/wedding";
	}
	
	@GetMapping("/rsvp/{id}")
	public String rsvp(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long weddingId = id;
		User rsvper = this.uService.find(userId);
		Wedding attendedWedding = this.wService.getById(weddingId);
		this.wService.addAttendee(rsvper, attendedWedding);
		return "redirect:/wedding";
	}
	
	
	
}
