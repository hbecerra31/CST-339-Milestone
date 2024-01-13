package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Model class representing user registration information.
 */
public class UserModel {

	private String id;

	@NotBlank(message = "First Name cannot be blank")
	@Size(min = 1, max = 32, message = "First Name must be between 1 and 32 characters")
	private String firstName;

	@NotBlank(message = "Last Name cannot be blank")
	@Size(min = 1, max = 32, message = "Last Name must be between 1 and 32 characters")
	private String lastName;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email must be a valid email address")
	private String email;

	@NotBlank(message = "Phone cannot be blank")
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be digits only")
	private String phoneNumber;

	@NotBlank(message = "User Name cannot be blank")
	@Size(min = 1, max = 32, message = "User Name must be between 1 and 32 characters")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;

	/**
	 * Default constructor for RegisterModel.
	 */
	public UserModel() {
	}

	/**
	 * Parameterized constructor for RegisterModel.
	 *
	 * @param id      	  The ID.
	 * @param firstName   The first name.
	 * @param lastName    The last name.
	 * @param email       The email address.
	 * @param phoneNumber The phone number.
	 * @param username    The username.
	 * @param password    The password.
	 */
	public UserModel(String id, String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets the user ID.
	 *
	 * @return The user ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userId The user ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return The first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName The first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return The last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName The last name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email address.
	 *
	 * @return The email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address.
	 *
	 * @param email The email address to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return The phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber The phone number to set.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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
	 * @return A string representation of the RegisterModel.
	 */
	@Override
	public String toString() {
		return "RegisterModel{" + 
							  "id='" + id + '\'' +
							  ", firstName='" + firstName + '\'' + 
							  ", lastName='" + lastName + '\'' + 
							  ", email='" + email + '\'' + 
							  ", phoneNumber=" + phoneNumber + 
							  ", username=" + username + 
							  ", password=" + password
				+ '}';
	}
}
