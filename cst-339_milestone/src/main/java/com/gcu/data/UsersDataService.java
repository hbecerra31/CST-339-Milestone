package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.UserEntity;

@Service
public class UsersDataService implements DataAccessInterface<UserEntity> {

	@Autowired
	private UsersRepository usersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for constructor injection
	 * @param dataSource 
	 */
	public UsersDataService(UsersRepository usersRepository,DataSource dataSource) {
		this.usersRepository = usersRepository;
		this.dataSource= dataSource;
		this.jdbcTemplateObject= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		
		try {
			// Get all the Entity Orders
			Iterable<UserEntity> usersIterable = usersRepository.findAll();
			// Convert to a List and return the List
			users = new ArrayList<UserEntity>();
			usersIterable.forEach(users::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the List
		return users;
	}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(UserEntity user) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
				// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
				String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USERNAME, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
				try {
					// Execute SQL Insert
					jdbcTemplateObject.update(sql, 
											  user.getFirstName(),
											  user.getLastName(), 
											  user.getEmail(),
											  user.getPhoneNumber(),
											  user.getUsername(),
											  user.getPassword());
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
	}

	@Override
	public boolean update(UserEntity user) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(UserEntity user) {
		// TODO Auto-generated method stub
		return true;
	}

}
