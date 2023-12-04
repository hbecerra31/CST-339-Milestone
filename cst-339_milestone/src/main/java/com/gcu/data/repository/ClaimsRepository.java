package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.ClaimEntity;

public interface ClaimsRepository extends CrudRepository<ClaimEntity, Long> {

	// Example of truly overriding a method from the CrudRepository and using our
	// own customized SQL
	@Override
	@Query(value = "SELECT * FROM CLAIMS")
	public List<ClaimEntity> findAll();
}
