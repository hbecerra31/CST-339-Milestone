package com.gcu.data;

/**
 * Interface for performing data access operations related to claims with additional methods.
 *
 * @param <T> The type of entity for which data access operations are defined.
 */
public interface ClaimsDataAccessInterface<T> {

    /**
     * Retrieves an entity of type T from the data source based on its claim ID.
     *
     * @param claimId The claim ID of the entity.
     * @return The entity with the specified claim ID, or null if not found.
     */
    public T findByClaimId(int claimId);
}
