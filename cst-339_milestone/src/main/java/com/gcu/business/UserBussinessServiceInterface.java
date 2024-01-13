/**
 * 
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

/**
 * 
 */
public interface UserBussinessServiceInterface {
	
	public void Test();
	
	public List<UserModel> getUsers();
	
	public UserModel getUserById(String id);
	
	public UserModel getUserByUsername(String username);
	
	public void createUser(UserModel claimModel);
	
	public void updateUser(UserModel userModel);
	
	public void deleteUser(UserModel userModel);
	
	public void init();
	
	public void destroy();

}
