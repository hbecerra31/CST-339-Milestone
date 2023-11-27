package com.gcu.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginModel {

	@NotBlank(message = "User Name cannot be blank")
	@Size(min = 1, max = 32, message = "User name must be between 1 and 32 character")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 character")
	private String password;

	// Constructors

	// Getter and setter methods

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
		return "LoginModel{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
