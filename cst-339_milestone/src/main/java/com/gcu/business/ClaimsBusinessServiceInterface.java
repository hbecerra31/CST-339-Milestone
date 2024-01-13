package com.gcu.business;

import java.util.List;

import com.gcu.model.ClaimModel;

/**
 * The interface for the Claims Business Service, providing methods for managing claims.
 * This interface outlines the operations that can be performed on claims.
 * 
 * @author Hugo Becerra
 */
public interface ClaimsBusinessServiceInterface {

    /**
     * A test method.
     */
    public void test();

    /**
     * Retrieves a list of all claims.
     *
     * @return List of ClaimModel objects.
     */
    public List<ClaimModel> getClaims();

    /**
     * Retrieves a specific claim by its ID.
     *
     * @param id The ID of the claim to retrieve.
     * @return The ClaimModel object with the specified ID.
     */
    public ClaimModel getClaimById(String id);

    /**
     * Retrieves a specific claim by its claim ID.
     *
     * @param claimId The claim ID of the claim to retrieve.
     * @return The ClaimModel object with the specified claim ID.
     */
    public ClaimModel getClaimByClaimId(int claimId);

    /**
     * Creates a new claim.
     *
     * @param claimModel The ClaimModel object to be created.
     */
    public void createClaim(ClaimModel claimModel);

    /**
     * Updates an existing claim.
     *
     * @param claimModel The ClaimModel object to be updated.
     */
    public void updateClaim(ClaimModel claimModel);

    /**
     * Deletes a claim.
     *
     * @param claimModel The ClaimModel object representing the claim to delete.
     */
    public void deleteClaim(ClaimModel claimModel);

    /**
     * Initialization method.
     */
    public void init();

    /**
     * Destruction method.
     */
    public void destroy();
}
