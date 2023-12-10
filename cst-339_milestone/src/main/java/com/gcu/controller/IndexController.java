package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.IndexModel;

/**
 * Controller class for handling requests related to the home page.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Handles the GET request for the home page.
     *
     * @return The ModelAndView for the home page.
     */
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("title", "Home");
        modelAndView.addObject("homeModel", new IndexModel());
        return modelAndView;
    }
}
