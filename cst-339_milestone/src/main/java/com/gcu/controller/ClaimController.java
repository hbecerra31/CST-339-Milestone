package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.ClaimModel;

@Controller
@RequestMapping("/claims")
public class ClaimController {
	
	@GetMapping("")
	public String display(Model model) {
		model.addAttribute("title", "Claims");
		model.addAttribute("claimModel", new ClaimModel());
		return "claims";
	}

}
