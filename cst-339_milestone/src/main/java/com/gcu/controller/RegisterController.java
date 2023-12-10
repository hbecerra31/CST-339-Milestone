package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessService;
import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

/**
 * Controller class for handling user registration operations.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserBusinessService users;

    /**
     * Displays the user registration form.
     *
     * @return The ModelAndView for the registration form view.
     */
    @GetMapping("")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("register"); // Set the view name
        modelAndView.addObject("title", "Register Form");
        modelAndView.addObject("registerModel", new RegisterModel());
        return modelAndView;
    }

    /**
     * Handles the submission of the user registration form.
     *
     * @param registerModel   The model representing the registration form.
     * @param bindingResult   The result of the binding and validation.
     * @return The ModelAndView for redirecting to the index page on successful registration.
     */
    @PostMapping("/create")
    public ModelAndView registerUser(@Valid RegisterModel registerModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            modelAndView.addObject("title", "Register Form");
            return modelAndView;
        }

        // Create a user and add to the database
        users.createUser(registerModel);

        // For now, you can print the user details to the console
        System.out.println(registerModel.toString());

        // Redirect to the index page
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
