package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessService;
import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserBusinessService users;

	@GetMapping("")
	public ModelAndView display(Model model) {
		ModelAndView modelAndView = new ModelAndView("register"); // Set the view name
		modelAndView.addObject("title", "Register Form");
		
		modelAndView.addObject("registerModel", new RegisterModel());
		
		return modelAndView;
	}

	@PostMapping("")
	public String registerUser(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}
		
		// Create a user and add to database
		users.createUser(registerModel);

		// For now, you can print the user details to the console
		System.out.println(registerModel.toString());

		return "index"; 
	}
}
