package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.IndexModel;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("title", "Home");
		model.addAttribute("homeModel", new IndexModel());
		return "index";

	}
}
