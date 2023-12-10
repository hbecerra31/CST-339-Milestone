package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;
import com.gcu.entity.UserEntity;

/**
 * Service class for performing CRUD operations on UserEntity using Spring Data.
 */
@Service
public class UsersDataService implements DataAccessInterface<UserEntity> {

    @Autowired
    private UsersRepository usersRepository;

    // Unused field; dataSource is not used in this class
    @SuppressWarnings("unused")
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    /**
     * Non-Default constructor for constructor injection.
     *
     * @param usersRepository The repository for UserEntity.
     * @param dataSource      The data source.
     */
    public UsersDataService(UsersRepository usersRepository, DataSource dataSource) {
        this.usersRepository = usersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
     * @return The UserEntity record with the specified identifier, or null if not found.
     */
    @Override
    public UserEntity findById(int id) {
        try {
            return usersRepository.findById((long) id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a new UserEntity record in the data source.
     *
     * @param user The UserEntity record to be created.
     * @return True if the UserEntity record was successfully created, false otherwise.
     */
    @Override
    public boolean create(UserEntity user) {
        // Example of "overriding" the CrudRepository save() method
        // You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
        String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USERNAME, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            // Execute SQL Insert using JdbcTemplate
            jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getPhoneNumber(), user.getUsername(), user.getPassword());
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
     * @return True if the UserEntity record was successfully updated, false otherwise.
     */
    @Override
    public boolean update(UserEntity user) {
        // TODO: Implement update logic if needed
        return true;
    }

    /**
     * Deletes a UserEntity record from the data source.
     *
     * @param user The UserEntity record to be deleted.
     * @return True if the UserEntity record was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(int id) {
        // TODO: Implement delete logic if needed
        return true;
    }
}
