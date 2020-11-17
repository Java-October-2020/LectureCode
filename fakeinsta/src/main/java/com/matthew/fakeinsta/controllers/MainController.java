package com.matthew.fakeinsta.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.fakeinsta.models.User;
import com.matthew.fakeinsta.services.PictureService;
import com.matthew.fakeinsta.services.UserService;

@Controller
@RequestMapping("/dashboard")
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private PictureService pService;
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
	
	@GetMapping("")
	public String dashboard(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		System.out.println(userId);
		User user = uService.find(userId);
		viewModel.addAttribute("users", this.uService.allUsers());
		viewModel.addAttribute("currentUser", user);
		viewModel.addAttribute("timeline", this.pService.getTimeline(user));
		return "/dashboard/landing.jsp";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("pic") MultipartFile file, @RequestParam("description") String desc, HttpSession session, RedirectAttributes redirectAttr) {
		User user = uService.find((Long)session.getAttribute("user_id"));
		// Save The Uploaded File To Our Static Folder
		if(file.isEmpty()) {
			redirectAttr.addFlashAttribute("messge", "Upload field cannot be empty");
			return "redirect:/dashboard";
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			// Get URL of File just uploaded
			String url = "/images/" + file.getOriginalFilename();
			this.pService.uploadPic(user, url, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/profile/{id}")
	public String profile(@PathVariable("id") Long id, Model viewModel) {
		User user = uService.find(id);
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("pictures", this.pService.userPictures(user));
		return "profile.jsp";
	}
	
	@GetMapping("/{id}")
	public String followUser(@PathVariable("id") Long id, HttpSession session) {
		User followedUser = this.uService.find(id);
		User user = this.uService.find((Long)session.getAttribute("user_id"));
		this.uService.followUser(user, followedUser);
		return "redirect:/dashboard";
	}
}
