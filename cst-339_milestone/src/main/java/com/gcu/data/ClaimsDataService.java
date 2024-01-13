package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ClaimsRepository;
import com.gcu.entity.ClaimEntity;

/**
 * Service class for performing CRUD operations on ClaimEntity using Spring
 * Data.
 */
@Service
public class ClaimsDataService implements DataAccessInterface<ClaimEntity>, ClaimsDataAccessInterface<ClaimEntity> {

	@Autowired
	private ClaimsRepository claimsRepository;

	/**
	 * Non-Default constructor for constructor injection.
	 *
	 * @param claimsRepository The repository for ClaimEntity.
	 */
	public ClaimsDataService(ClaimsRepository claimsRepository) {
		this.claimsRepository = claimsRepository;
	}

	/**
	 * Retrieves all ClaimEntity records from the data source.
	 *
	 * @return A list of ClaimEntity records.
	 */
	@Override
	public List<ClaimEntity> findAll() {
		List<ClaimEntity> claims = new ArrayList<>();

		try {
			// Get all the ClaimEntity records from the repository
			Iterable<ClaimEntity> claimsIterable = claimsRepository.findAll();

			// Convert to a List and return the List
			claims = new ArrayList<ClaimEntity>();
			claimsIterable.forEach(claims::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the List of ClaimEntity records
		return claims;
	}

	/**
	 * Retrieves a single ClaimEntity record based on its unique identifier.
	 *
	 * @param id The unique identifier of the ClaimEntity record.
	 * @return The ClaimEntity record with the specified identifier, or null if not
	 *         found.
	 */
	@Override
	public ClaimEntity findById(String id) {
		try {
			return claimsRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves a single ClaimEntity record based on its claim ID.
	 * 
	 * @param claimId The claim ID.
	 * @return The ClaimEntity record with the specified identifier, or null if not
	 *         found.
	 */
	@Override
	public ClaimEntity findByClaimId(int claimId) {
		try {
			return claimsRepository.findByClaimId(claimId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a new ClaimEntity record in the data source.
	 *
	 * @param claim The ClaimEntity record to be created.
	 * @return True if the ClaimEntity record was successfully created, false
	 *         otherwise.
	 */
	@Override
	public boolean create(ClaimEntity claim) {

		try {
			claimsRepository.insert(claim);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Updates an existing ClaimEntity record in the data source.
	 *
	 * @param claim The ClaimEntity record to be updated.
	 * @return True if the ClaimEntity record was successfully updated, false
	 *         otherwise.
	 */
	@Override
	public boolean update(ClaimEntity claim) {

		try {
			claim.setId(claimsRepository.findByClaimId(claim.getClaimId()).getId()); // TODO: Find a better way...
			claimsRepository.save(claim);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Deletes a ClaimEntity record from the data source.
	 *
	 * @param claim The ClaimEntity record to be deleted.
	 * @return True if the ClaimEntity record was successfully deleted, false
	 *         otherwise.
	 */
	@Override
	public boolean delete(ClaimEntity claim) {

		try {
			claim.setId(claimsRepository.findByClaimId(claim.getClaimId()).getId()); // TODO: Find a better way...
			claimsRepository.delete(claim);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
