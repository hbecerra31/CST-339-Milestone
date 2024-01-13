/**
 * Interface for the User Business Service, providing methods for managing users.
 * This interface outlines the operations that can be performed on users.
 * 
 * @author Hugo Becerra
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

/**
 * The interface for the User Business Service, providing methods for managing users.
 * This interface outlines the operations that can be performed on users.
 * 
 * @author Hugo Becerra
 */
public interface UserBusinessServiceInterface {
    
    /**
     * A test method.
     */
    public void test();

    /**
     * Retrieves a list of all users.
     *
     * @return List of UserModel objects.
     */
    public List<UserModel> getUsers();

    /**
     * Retrieves a specific user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The UserModel object with the specified ID.
     */
    public UserModel getUserById(String id);

    /**
     * Retrieves a specific user by their username.
     *
     * @param username The username of the user to retrieve.
     * @return The UserModel object with the specified username.
     */
    public UserModel getUserByUsername(String username);

    /**
     * Creates a new user.
     *
     * @param userModel The UserModel object to be created.
     */
    public void createUser(UserModel userModel);

    /**
     * Updates an existing user.
     *
     * @param userModel The UserModel object to be updated.
     */
    public void updateUser(UserModel userModel);

    /**
     * Deletes a user.
     *
     * @param userModel The UserModel object representing the user to delete.
     */
    public void deleteUser(UserModel userModel);

    /**
     * Initialization method.
     */
    public void init();

    /**
     * Destruction method.
     */
    public void destroy();
}
