package com.gcu.data.repository;

import java.util.List;



import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.entity.UserEntity;

/**
 * Repository interface for accessing and managing UserEntity instances in the database.
 */
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    /**
     * Overrides the default findAll method to use a custom SQL query.
     *
     * @return A list of all UserEntity instances in the database.
     */
    @Override
    @Query(value = "SELECT * FROM USERS")
    public List<UserEntity> findAll();
    
    @Query(value = "SELECT * FROM USERS WHERE USERNAME = :username")
	public UserEntity findByUsername(@Param ("name") String username);
}
