package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.UserEntity;

/**
 * Service class for performing CRUD operations on UserEntity using Spring Data.
 */
@Service
public class UsersDataService implements DataAccessInterface<UserEntity>, UsersDataAccessInterface<UserEntity> {

	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Non-Default constructor for constructor injection.
	 *
	 * @param usersRepository The repository for UserEntity.
	 */
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	/**
	 * Retrieves all UserEntity records from the data source.
	 *
	 * @return A list of UserEntity records.
	 */
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = new ArrayList<>();

		try {
			// Get all the UserEntity records from the repository
			Iterable<UserEntity> usersIterable = usersRepository.findAll();
			// Convert to a List and return the List
			users = new ArrayList<>();
			usersIterable.forEach(users::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the List of UserEntity records
		return users;
	}

	/**
	 * Retrieves a single UserEntity record based on its unique identifier.
	 *
	 * @param id The unique identifier of the UserEntity record.
	 * @return The UserEntity record with the specified identifier, or null if not
	 *         found.
	 */
	@Override
	public UserEntity findById(String id) {
		try {
			return usersRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves a single UserEntity record based on its username.
	 * 
	 * @param username The username.
	 * @return The UserEntity record with the specified identifier, or null if not
	 *         found.
	 */
	@Override
	public UserEntity findByUsername(String username) {
		try {
			return usersRepository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a new UserEntity record in the data source.
	 *
	 * @param user The UserEntity record to be created.
	 * @return True if the UserEntity record was successfully created, false
	 *         otherwise.
	 */
	@Override
	public boolean create(UserEntity user) {
		try {
			usersRepository.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Updates an existing UserEntity record in the data source.
	 *
	 * @param user The UserEntity record to be updated.
	 * @return True if the UserEntity record was successfully updated, false
	 *         otherwise.
	 */
	@Override
	public boolean update(UserEntity user) {
		try {
			// TODO: Test that it does not create a new document
			usersRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Deletes a UserEntity record from the data source.
	 *
	 * @param user The UserEntity record to be deleted.
	 * @return True if the UserEntity record was successfully deleted, false
	 *         otherwise.
	 */
	@Override
	public boolean delete(UserEntity user) {
		try {
			// TODO: Test that it deletes the document
			usersRepository.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
