package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.ClaimEntity;

/**
 * Repository interface for accessing and managing ClaimEntity instances in the database.
 */
public interface ClaimsRepository extends CrudRepository<ClaimEntity, Long> {

    /**
     * Overrides the default findAll method to use a custom SQL query.
     *
     * @return A list of all ClaimEntity instances in the database.
     */
    @Override
    @Query(value = "SELECT * FROM CLAIMS")
    public List<ClaimEntity> findAll();
}
