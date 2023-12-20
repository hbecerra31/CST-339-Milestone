package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.entity.ClaimEntity;
import com.gcu.entity.UserEntity;
import com.gcu.model.ClaimModel;
import com.gcu.model.UserModel;

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
	public List<UserModel> getUsers() {
		
		// Get all the Entity Users
		List<UserEntity> userEntity = service.findAll();
		
		// Iterate over the Entity Users and create a list of Domain Users
		List<UserModel> usersDomain = new ArrayList<UserModel>();
		for(UserEntity entity : userEntity) {
			usersDomain.add(new UserModel(entity.getUserId(),
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
	public void createUser(UserModel registerModel) {
		UserEntity userEntity = new UserEntity(registerModel.getUserId(),
											   registerModel.getFirstName(),
											   registerModel.getLastName(),
											   registerModel.getEmail(),
											   registerModel.getPhoneNumber(),
											   registerModel.getUsername(),
											   registerModel.getPassword());
		service.create(userEntity);
	}
	
	public UserModel getUserById(int userId) {
		UserEntity user = service.findById(userId);
		return new UserModel(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPhoneNumber(), user.getUsername(), user.getPassword());
	}
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = service.findByUsername(username);
		if (user!=null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		
		throw new UsernameNotFoundException("Username not found");
	}
}
