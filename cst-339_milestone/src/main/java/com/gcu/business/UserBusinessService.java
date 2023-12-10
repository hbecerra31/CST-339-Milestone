package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.entity.UserEntity;
import com.gcu.model.RegisterModel;

/**
 * Service class for managing user-related business operations.
 */
@Service
public class UserBusinessService {
	
	@Autowired
	private UsersDataService service;
	
	/**
	 * Retrieves a list of user models representing all users in the system.
	 * 
	 * @return List of RegisterModel representing users
	 */
	public List<RegisterModel> getUsers() {
		
		// Get all the Entity Users
		List<UserEntity> userEntity = service.findAll();
		
		// Iterate over the Entity Users and create a list of Domain Users
		List<RegisterModel> usersDomain = new ArrayList<RegisterModel>();
		for(UserEntity entity : userEntity) {
			usersDomain.add(new RegisterModel(entity.getUserId(),
											  entity.getFirstName(),
											  entity.getLastName(),
											  entity.getEmail(),
											  entity.getPhoneNumber(),
											  entity.getUsername(),
											  entity.getPassword()));
		}
		
		// Return list of Domain Users
		return usersDomain;
	}

	/**
	 * Creates a new user using the provided RegisterModel.
	 * 
	 * @param registerModel The RegisterModel containing user information
	 */
	public void createUser(RegisterModel registerModel) {
		UserEntity userEntity = new UserEntity(registerModel.getUserId(),
											   registerModel.getFirstName(),
											   registerModel.getLastName(),
											   registerModel.getEmail(),
											   registerModel.getPhoneNumber(),
											   registerModel.getUsername(),
											   registerModel.getPassword());
		service.create(userEntity);
	}
}
