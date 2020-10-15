package com.matthew.ninjaGold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	// @RequestMapping(value="/", method=requestMethod.GET)
	// @RequestMapping(value="/findGold", method=requestMethod.POST)
	
	@GetMapping("/")
	public String goldLanding(HttpSession session, Model viewModel) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		
		viewModel.addAttribute("gold", session.getAttribute("gold"));
		viewModel.addAttribute("activity", session.getAttribute("activity"));
		return "gold.jsp";
	}
	
	@PostMapping("/findGold")
	public String goldProcessing(HttpSession session, @RequestParam("building") String building) {
		// (max - min + 1) + min
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn;
		// doing gold Logic
		if(building.equals("farm")) {
			// do farm stuff
			goldThisTurn = r.nextInt((20 - 10) + 1) + 10;
			activity.add(String.format("You entered a farm and earned %d gold\n", goldThisTurn));
			
		} else if(building.equals("cave")) {
			// do cave stuff
			goldThisTurn = r.nextInt((10 - 5) + 1) + 5;
			activity.add(String.format("You entered a cave and earned %d gold\n", goldThisTurn));
		} else if (building.equals("house")) {
			// do house stuff
			goldThisTurn = r.nextInt((5 - 2) + 1) + 2;
			activity.add(String.format("You entered a house and earned %d gold\n", goldThisTurn));
		} else {
			// do do casino stuff
			goldThisTurn = r.nextInt((50 + 50) + 1) - 50;
			if(goldThisTurn > 0) {
			activity.add(String.format("You entered a Casino and earned %d gold\n", goldThisTurn));
			} else {
			activity.add(String.format("You entered a Casino and lost %d gold. Ouch! \n", goldThisTurn));
			}
			}
		
		int totalGold = gold + goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activity", activity);
		return "redirect:/";
	}
}
