package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ClaimsRepository;
import com.gcu.entity.ClaimEntity;

@Service
public class ClaimsDataService implements DataAccessInterface<ClaimEntity> {

	@Autowired
	private ClaimsRepository claimsRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	

	/**
	 * Non-Default constructor for constructor injection
	 * @param dataSource 
	 */
	public ClaimsDataService(ClaimsRepository claimsRepository, DataSource dataSource) {
		this.claimsRepository = claimsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * CRUD: finder to return all entities
	 */
	@Override
	public List<ClaimEntity> findAll() {
		List<ClaimEntity> orders = new ArrayList<ClaimEntity>();

		try {
			// Get all the Entity Orders
			Iterable<ClaimEntity> ordersIterable = claimsRepository.findAll();
			// Convert to a List and return the List
			orders = new ArrayList<ClaimEntity>();
			ordersIterable.forEach(orders::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the List
		return orders;
	}

	/**
	 * CRUD: finder to return a single entity
	 */
	@Override
	public ClaimEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(ClaimEntity claim) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO CLAIMS(PATIENT_NAME, DIAGNOSIS, CLAIM_DATE, CLAIM_AMOUNT) VALUES(?, ?, ?, ?)";
		try {
			// Execute SQL Insert
			jdbcTemplateObject.update(sql, 
									  claim.getPatientName(),
									  claim.getDiagnosis(), 
									  claim.getClaimDate(),
									  claim.getClaimAmount());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(ClaimEntity claim) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(ClaimEntity claim) {
		// TODO Auto-generated method stub
		return true;
	}

}
