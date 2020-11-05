package com.matthew.records.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.records.models.Label;
import com.matthew.records.models.Record;
import com.matthew.records.models.User;
import com.matthew.records.services.LabelService;
import com.matthew.records.services.RecordService;
import com.matthew.records.services.UserService;


@Controller
@RequestMapping("/dashboard")
public class RecordController {
	@Autowired
	private RecordService rService;
	@Autowired
	private LabelService lService;
	@Autowired
	private UserService uService;
	
	@GetMapping("")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {

			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		System.out.println(userId);
		User user = this.uService.findOneUser(userId);
		List<Record> records = this.rService.getAllRecords();
		viewModel.addAttribute("allRecords", records);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	
	//Non JPA Way
//	@PostMapping("/addOldWay")
//	public String addAlbum(@RequestParam("artistName") String name, @RequestParam("albumName") String album, @RequestParam("year") int year, RedirectAttributes redirectAttrs) {
//		ArrayList<String> errors = new ArrayList<String>();
//		if(name.equals("")) {
//			errors.add("Hey there, you forgot to add an artist name");
//		}
//		if(errors.size() > 0) {
//			for(String e: errors) {
//				redirectAttrs.addFlashAttribute("errors", e);
//			}
//			return "redirect:/add";
//		}
//		
//		this.rService.createRecord(name, album, year);
//		return "redirect:/";
//	}
	
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
	
	
	@GetMapping("/{id}")
	public String showRecord(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("record") Record record, @ModelAttribute("label") Label label) {
		viewModel.addAttribute("record", this.rService.getOneRecord(id));
		return "show.jsp";
	}
	
	
	@PostMapping("/label")
	public String createLabel(@Valid @ModelAttribute("label") Label label, BindingResult result, Model viewModel) {

		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			this.lService.create(label);
			return "redirect:/";
		}
	}
	
	//@PutMapping
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
//	public String updateRecord(@Valid @ModelAttribute("record") Record updatedRecord, BindingResult result) {
//		if(result.hasErrors()) {
//			return "show.jsp";
//		} else {
//			this.rService.updateRecord(updatedRecord);
//			return "redirect:/";
//		}
//	}
	
	@PostMapping("/{id}")
	public String updateRecord(@Valid @ModelAttribute("record") Record updatedRecord, BindingResult result, @ModelAttribute("label") Label label) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			this.rService.updateRecord(updatedRecord);
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRecord(@PathVariable("id") Long id) {
		this.rService.deleteRecord(id);
		return "redirect:/";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long recordID = id;
		User liker = this.uService.findOneUser(userId);
		Record likedRecord = this.rService.getOneRecord(recordID);
		this.rService.addLiker(liker, likedRecord);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long recordID = id;
		User unliker = this.uService.findOneUser(userId);
		Record unlikedRecord = this.rService.getOneRecord(recordID);
		this.rService.removeLiker(unliker, unlikedRecord);
		return "redirect:/dashboard";
	}
	
}
