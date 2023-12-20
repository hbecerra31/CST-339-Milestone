package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ClaimsBusinessServiceInterface;
import com.gcu.model.ClaimModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimsBusinessServiceInterface claims;

    /**
     * Displays the claims view.
     *
     * @return ModelAndView object for the claims view.
     */
    @GetMapping("")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("claims");
        modelAndView.addObject("title", "Claims");
        modelAndView.addObject("claims", claims.getClaims());
        return modelAndView;
    }

    /**
     * Displays the new claim form.
     *
     * @return ModelAndView object for the new claim form view.
     */
    @GetMapping("/newClaim")
    public ModelAndView newClaim() {
        ModelAndView modelAndView = new ModelAndView("claimNew");
        modelAndView.addObject("title", "New Claim");
        modelAndView.addObject("claimModel", new ClaimModel());
        return modelAndView;
    }

    /**
     * Handles the creation of a new claim.
     *
     * @param claimModel     The claim model to be created.
     * @param bindingResult  BindingResult for validation.
     * @return Redirects to the claims view on success, or stays on the new claim form on validation errors.
     */
    @PostMapping("/create")
    public ModelAndView createClaim(@Valid ClaimModel claimModel, BindingResult bindingResult) {
    	ModelAndView modelAndView = new ModelAndView();
    	
    	// Check for validation errors
    	if (bindingResult.hasErrors()) {
    		modelAndView.setViewName("claimNew");
    		modelAndView.addObject("title", "New Claim");
            return modelAndView;
        }

    	// Create a claim and add to the database
        claims.createClaim(claimModel);

        modelAndView.setViewName("redirect:/claims");

        return modelAndView;
    }

    /**
     * Displays the details of a specific claim.
     *
     * @param claimId        The ID of the claim to view.
     * @return ModelAndView object for the claim details view.
     */
    @GetMapping("/view")
	public ModelAndView viewClaim(@RequestParam(name = "claimNumber", required = false) int claimId) {
		ModelAndView modelAndView = new ModelAndView("claimDetails"); // Set the view name
		modelAndView.addObject("title", "Claim Details");

		// Fetch the specific claim by its ID
		ClaimModel claimModel = claims.getClaimById(claimId);

		// Check if the claim exists
		if (claimModel == null) {
			// Handle the case where the claim is not found
			modelAndView.addObject("errorMessage", "Claim not found");
			return modelAndView;
		}

		modelAndView.addObject("claimModel", claimModel);

		return modelAndView;
	}

    /**
     * Handles the update of a claim.
     *
     * @param claimModel     The claim model to be updated.
     * @return Redirects to the claims view.
     */
    @PostMapping("/update")
    public ModelAndView updateClaim(@ModelAttribute ClaimModel claimModel) {
    	ModelAndView modelAndView = new ModelAndView();
    	claims.updateClaim(claimModel);
    	modelAndView.setViewName("redirect:/claims");
        return modelAndView;
    }

    /**
     * Handles the deletion of a claim.
     *
     * @param claimId        The ID of the claim to delete.
     * @return Redirects to the claims view.
     */
    @GetMapping("/delete")
    public ModelAndView deleteClaim(@RequestParam int claimId) {
    	ModelAndView modelAndView = new ModelAndView();
    	claims.deleteClaimById(claimId);
    	modelAndView.setViewName("redirect:/claims");
        return modelAndView;
    }
}
