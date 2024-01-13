package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gcu.entity.UserEntity;

/**
 * Repository interface for accessing and managing UserEntity instances in the
 * database.
 */
public interface UsersRepository extends MongoRepository<UserEntity, String> {

	/**
	 * Finds the User Entity by the username
	 * 
	 * @param username the user's username
	 * @return The User Entity
	 */
	public UserEntity findByUsername(String username);
}
