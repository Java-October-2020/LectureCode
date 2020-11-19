package com.matthew.products.controllers;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.products.models.Category;
import com.matthew.products.models.Product;
import com.matthew.products.models.Rating;
import com.matthew.products.models.User;
import com.matthew.products.services.CategoryService;
import com.matthew.products.services.ProductService;
import com.matthew.products.services.RatingService;
import com.matthew.products.services.UserService;
import com.matthew.products.validators.UserValidator;

@Controller
public class MainController {
	@Autowired
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private RatingService rService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {

		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			//If there are validation errors:
			// We want to return them directly to the registration page
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenicateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {

			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		List<Product> products = this.pService.getAllProduct();
		viewModel.addAttribute("allProducts", products);
		viewModel.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProd(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}

	
	@GetMapping("/category/new")
	public String newCat(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProd(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		product.setCreator(user);
		pService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@PostMapping("/category/new")
	public String addCat(@Valid @ModelAttribute("Category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}
		this.cService.createCat(category);
		return "redirect:/category/new";
	}
	
	@GetMapping("/product/{id}")
	public String showProd(@ModelAttribute("rating") Rating rating, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Product product = this.pService.findById(id);
		viewModel.addAttribute("product", product);
		List<Category> unqiueCats = this.cService.catsNotAdded(product);
		viewModel.addAttribute("uniqueCats", unqiueCats);
		List<Category> categories = product.getCategories();
		viewModel.addAttribute("categories", categories);
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		viewModel.addAttribute("user", user);
		List<Rating> ratingz = product.getRatings();
		for(Rating r : ratingz) {
			System.out.println(r.getUser().getFirstName());
		}
		return "/products/show.jsp";
	}
	
	@PostMapping("/product/rate/{id}")
	public String rateProd(@RequestParam("rating") Float rating, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
			Product product = this.pService.findById(id);
			Long user_id = (Long)session.getAttribute("user_id");
			User user = this.uService.findOneUser(user_id);
			Rating newRating = new Rating();
			newRating.setRating(rating);
			newRating.setProduct(product);
			newRating.setUser(user);
			this.rService.createRating(newRating);
			return "redirect:/product/{id}";
	}
	
	@GetMapping("/category/{id}")
	public String showCat(@PathVariable("id") Long id, Model viewModel) {
		Category category = this.cService.findById(id);
		List<Product> products = category.getProducts();
		viewModel.addAttribute("category", category);
		viewModel.addAttribute("products", products);
		List<Product> unAdded = this.pService.getUniqueCats(category);
		viewModel.addAttribute("unAdded", unAdded);
		return "/categories/show.jsp";
	}
	
	@PostMapping("/product/addCategory/{id}")
	public String addCat(@PathVariable("id") Long id, @RequestParam("category") Long catId) {
		Long productId = id;
		Category category = this.cService.findById(catId);
		Product productOfCatToAdd = this.pService.findById(productId);
		this.pService.addProductToCat(productOfCatToAdd, category);
		return "redirect:/product/" + id;
	}
	
	
	
}
