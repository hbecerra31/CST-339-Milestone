package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ClaimsRepository;
import com.gcu.entity.ClaimEntity;

/**
 * Service class for performing CRUD operations on ClaimEntity using Spring Data.
 */
@Service
public class ClaimsDataService implements DataAccessInterface<ClaimEntity> {

    @Autowired
    private ClaimsRepository claimsRepository;

    // Unused field; dataSource is not used in this class
    @SuppressWarnings("unused")
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    /**
     * Non-Default constructor for constructor injection.
     *
     * @param claimsRepository The repository for ClaimEntity.
     * @param dataSource       The data source.
     */
    public ClaimsDataService(ClaimsRepository claimsRepository, DataSource dataSource) {
        this.claimsRepository = claimsRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
            claims = new ArrayList<>();
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
     * @return The ClaimEntity record with the specified identifier, or null if not found.
     */
    @Override
    public ClaimEntity findById(int id) {
        try {
            return claimsRepository.findById((long) id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a new ClaimEntity record in the data source.
     *
     * @param claim The ClaimEntity record to be created.
     * @return True if the ClaimEntity record was successfully created, false otherwise.
     */
    @Override
    public boolean create(ClaimEntity claim) {
        // Example of "overriding" the CrudRepository save() method
        // You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
        String sql = "INSERT INTO CLAIMS(PATIENT_NAME, DIAGNOSIS, CLAIM_DATE, CLAIM_AMOUNT) VALUES(?, ?, ?, ?)";
        try {
            // Execute SQL Insert using JdbcTemplate
            jdbcTemplateObject.update(sql, claim.getPatientName(), claim.getDiagnosis(),
                    claim.getClaimDate(), claim.getClaimAmount());
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
     * @return True if the ClaimEntity record was successfully updated, false otherwise.
     */
    @Override
    public boolean update(ClaimEntity claim) {
        try {
            // Save the updated entity using CrudRepository's save() method
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
     * @return True if the ClaimEntity record was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(int claimId) {
        try {
            // Delete the entity using CrudRepository's delete() method
            claimsRepository.deleteById((long) claimId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
