package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("")
	public String display(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}

		// For now, you can print the user details to the console
		System.out.println(registerModel.toString());

		return "index"; 
	}
}
