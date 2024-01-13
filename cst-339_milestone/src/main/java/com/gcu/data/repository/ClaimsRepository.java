package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.entity.ClaimEntity;

/**
 * Repository interface for accessing and managing ClaimEntity instances in the
 * database.
 */
public interface ClaimsRepository extends MongoRepository<ClaimEntity, String> {

	/**
	 * Finds the Claim by the claim ID
	 * 
	 * @param claimId The claim ID to find
	 * @return The Claim Entity
	 */
	public ClaimEntity findByClaimId(int claimId);

}
