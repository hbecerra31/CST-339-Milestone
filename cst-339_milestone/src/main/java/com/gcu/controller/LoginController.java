package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling requests related to the login page.
 * This class defines a method to display the login form view.
 * 
 * @author Hugo Becerra
 */
@Controller
public class LoginController {

    /**
     * Displays the login form view.
     *
     * @param model The Model to add attributes for the view.
     * @return The name of the login form view.
     */
    @GetMapping("/login")
    public String display(Model model) {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        return "login";
    }
}
