package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.entity.UserEntity;
import com.gcu.model.RegisterModel;

@Service
public class UserBusinessService {
	
	@Autowired
	private UsersDataService service;
	
	public List<RegisterModel> getUsers() {
		
		// Get all the Entity Users
		List<UserEntity> userEntity = service.findAll();
		
		// Iterate over the Entity Orders and create a list of Domain Orders
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
