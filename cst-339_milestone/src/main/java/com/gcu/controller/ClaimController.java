package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ClaimsBusinessServiceInterface;
import com.gcu.model.ClaimModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/claims")
public class ClaimController {
	
	@Autowired
	private ClaimsBusinessServiceInterface claims;
	
	@GetMapping("")
	public ModelAndView display() {
		ModelAndView modelAndView = new ModelAndView("claim"); // Set the view name
		modelAndView.addObject("title", "Claims");
		
		modelAndView.addObject("claims", claims.getClaims());
		
		return modelAndView;
	}
	
	@GetMapping("/newClaim")
	public ModelAndView newClaim() {
		ModelAndView modelAndView = new ModelAndView("claimNew"); // Set the view name
		modelAndView.addObject("title", "New Claim");
		
		modelAndView.addObject("claimModel", new ClaimModel());
				
		return modelAndView;
	}
	
	@PostMapping("")
	public String createClaim(@Valid ClaimModel claimModel, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "New Claim");
			return "claimNew";
		}
		
		// Create claim and add to database
		claims.createClaim(claimModel);
		
		// Return to Claims view
		model.addAttribute("title", "Claims");
		model.addAttribute("claims", claims.getClaims());
		
		return "claim"; 
	}
	


}
