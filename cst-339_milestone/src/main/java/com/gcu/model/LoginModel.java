package com.gcu.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Model class representing user login information.
 */
public class LoginModel {

    @NotBlank(message = "User Name cannot be blank")
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Overrides the default toString method for better logging or debugging.
     *
     * @return A string representation of the LoginModel.
     */
    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
