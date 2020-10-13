package com.matthew.sampleProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/{color}", method=RequestMethod.GET)
	private String color(@PathVariable("color") String color, Model viewModel) {
		viewModel.addAttribute("favoriteColor", color);
		return "color.jsp";
	}
	
	@RequestMapping(value="/submitjoke", method=RequestMethod.POST)
	private String submitJoke(@RequestParam(value="name") String name, @RequestParam(value="email") String email, @RequestParam(value="joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("email", email);
		viewModel.addAttribute("joke", joke);
		return "result.jsp";
	}
	
	@RequestMapping(value="/new")
	private String newJoke() {
		return "new.jsp";
	}
}
