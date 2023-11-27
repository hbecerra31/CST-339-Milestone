package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterModel {

	@NotBlank(message = "First Name cannot be blank")
	@Size(min = 1, max = 32, message = "First Name must be between 1 and 32 character")
	private String firstName;

	@NotBlank(message = "Last Name cannot be blank")
	@Size(min = 1, max = 32, message = "Last Name must be between 1 and 32 character")
	private String lastName;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email must be valid email")
	private String email;

	@NotBlank(message = "Phone cannot be blank")
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be digits only")
	private String phoneNumber;

	@NotBlank(message = "User Name cannot be blank")
	@Size(min = 1, max = 32, message = "User Name must be between 1 and 32 character")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 character")
	private String password;

	// Constructors

	// Getter and setter methods

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString method for better logging or debugging

	@Override
	public String toString() {
		return "RegisterModel{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='"
				+ email + '\'' + ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password
				+ '}';
	}

}
