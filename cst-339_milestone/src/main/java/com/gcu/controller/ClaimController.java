package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.ClaimModel;
import com.gcu.repository.ClaimCollectionRepository;

@RestController
@RequestMapping("/claims")
public class ClaimController {
	
	@Autowired
	private ClaimCollectionRepository claims;
	
	@GetMapping("")
	public ModelAndView display() {
		ModelAndView modelAndView = new ModelAndView("claim"); // Set the view name
		modelAndView.addObject("title", "Claims");
		modelAndView.addObject("claimModel", new ClaimModel());
		
		for(ClaimModel c: claims.findAll()) {
			System.out.println(c);
		}
		
		return modelAndView;
	}
	
	public List<ClaimModel> findAll() {
		return claims.findAll();
	}

}
