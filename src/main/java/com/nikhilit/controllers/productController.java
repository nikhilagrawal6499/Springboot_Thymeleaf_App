package com.nikhilit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nikhilit.models.Product;

import jakarta.validation.Valid;

@Controller
public class productController {

	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg", "Welcome to Thymeleaf App..");
		return "index";
	}

	// load the form
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	// method to handle submit btn
	@PostMapping("/product")
	public String handleSubmitBtn(@Valid Product p, BindingResult result, Model model) {
		System.out.println(p);

		if (result.hasErrors()) {
			return "index";
		} else {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}
}
