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
import com.gcu.entity.UserEntity;
import com.gcu.model.UserModel;

/**
 * Service class for managing user-related business operations.
 * This class provides methods for interacting with user data and implementing
 * user authentication.
 * 
 * @author Hugo Becerra
 */
@Service
public class UserBusinessService implements UserBusinessServiceInterface {

    @Autowired
    private UsersDataService service;

    @Override
    public void test() {
        System.out.println("Hello from the UserBusinessService.test()");
    }

    /**
     * Retrieves a list of user models representing all users in the system.
     * 
     * @return List of UserModel representing users
     */
    @Override
    public List<UserModel> getUsers() {
        // Get all the Entity Users
        List<UserEntity> userEntities = service.findAll();

        // Iterate over the Entity Users and create a list of Domain Users
        List<UserModel> users = new ArrayList<>();
        for (UserEntity entity : userEntities) {
            users.add(new UserModel(entity.getId(),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getEmail(),
                    entity.getPhoneNumber(),
                    entity.getUsername(),
                    entity.getPassword()));
        }

        // Return list of Domain Users
        return users;
    }

    @Override
    public UserModel getUserById(String userId) {
        UserEntity userEntity = service.findById(userId);
        return new UserModel(userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhoneNumber(),
                userEntity.getUsername(),
                userEntity.getPassword());
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserEntity userEntity = service.findByUsername(username);
        return new UserModel(userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhoneNumber(),
                userEntity.getUsername(),
                userEntity.getPassword());
    }

    /**
     * Creates a new user using the provided RegisterModel.
     * 
     * @param userModel The RegisterModel containing user information
     */
    public void createUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity(userModel.getId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPhoneNumber(),
                userModel.getUsername(),
                userModel.getPassword());
        service.create(userEntity);
    }

    @Override
    public void updateUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity(userModel.getId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPhoneNumber(),
                userModel.getUsername(),
                userModel.getPassword());
        service.update(userEntity);
    }

    @Override
    public void deleteUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity(userModel.getId(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPhoneNumber(),
                userModel.getUsername(),
                userModel.getPassword());
        service.delete(userEntity);
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * Custom implementation of loading user details for authentication.
     * 
     * @param username The username of the user to load details for.
     * @return UserDetails object representing the user.
     * @throws UsernameNotFoundException If the user is not found.
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = service.findByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("Username not found");
    }
}
