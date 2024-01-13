package com.gcu.data;

/**
 * Interface for performing data access operations related to users with additional methods.
 *
 * @param <T> The type of entity for which data access operations are defined.
 */
public interface UsersDataAccessInterface<T> {

    /**
     * Retrieves an entity of type T from the data source based on its username.
     *
     * @param username The username of the entity.
     * @return The entity with the specified username, or null if not found.
     */
    public T findByUsername(String username);
}
