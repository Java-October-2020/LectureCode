package com.matthew.records.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matthew.records.models.User;
import com.matthew.records.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<User> users = this.uService.allUsers();
		viewModel.addAttribute("users", users);
		return "landing.jsp";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Model viewModel, @RequestParam("users") Long id) {
		if(session.getAttribute("user_id") == null){
			session.setAttribute("user_id", id);
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
