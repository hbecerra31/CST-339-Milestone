package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.entity.ClaimEntity;

/**
 * Repository interface for accessing and managing ClaimEntity instances in the
 * database.
 */
public interface ClaimsRepository extends MongoRepository<ClaimEntity, String> {

	public ClaimEntity findByClaimId(int claimId);

}
