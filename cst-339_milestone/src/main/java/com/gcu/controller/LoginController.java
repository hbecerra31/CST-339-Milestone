package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

/**
 * Controller class for handling login-related requests.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * Displays the login form.
     *
     * @param model The model to be populated with data.
     * @return The ModelAndView for the login form.
     */
    @GetMapping("")
    public ModelAndView display(Model model) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("title", "Login Form");
        modelAndView.addObject("loginModel", new LoginModel());
        return modelAndView;
    }

    /**
     * Processes the login form submission.
     *
     * @param loginModel      The model representing the login form.
     * @param bindingResult   The result of the binding and validation.
     * @return The ModelAndView for the next view based on the result of form submission.
     */
    @PostMapping("")
    public ModelAndView doLogin(@Valid LoginModel loginModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
            modelAndView.addObject("title", "Login Form");
            return modelAndView;
        }

        // Print the form values out
        System.out.println(loginModel);

        // Navigate to Index View
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
