package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ClaimsDataService;
import com.gcu.entity.ClaimEntity;
import com.gcu.model.ClaimModel;

/**
 * Service class implementing the ClaimsBusinessServiceInterface for managing claims.
 * This class provides methods for interacting with claims data.
 * 
 * @author Hugo Becerra
 */
@Service
public class ClaimsBusinessService implements ClaimsBusinessServiceInterface {

    @Autowired
    private ClaimsDataService service;

    @Override
    public void test() {
        System.out.println("Hello from the ClaimsBusinessService.test()");
    }

    @Override
    public List<ClaimModel> getClaims() {
        // Get all the Entity Claims
        List<ClaimEntity> claimEntities = service.findAll();

        // Iterate over the Entity Claims and create a list of Domain Claims
        List<ClaimModel> claims = new ArrayList<>();
        for (ClaimEntity entity : claimEntities) {
            claims.add(new ClaimModel(entity.getId(),
                    entity.getClaimId(),
                    entity.getPatientName(),
                    entity.getDiagnosis(),
                    entity.getClaimDate(),
                    entity.getClaimAmount()));
        }

        // Return list of Domain Claims
        return claims;
    }

    @Override
    public ClaimModel getClaimById(String id) {
        ClaimEntity claimEntity = service.findById(id);
        return new ClaimModel(claimEntity.getId(),
                claimEntity.getClaimId(),
                claimEntity.getPatientName(),
                claimEntity.getDiagnosis(),
                claimEntity.getClaimDate(),
                claimEntity.getClaimAmount());
    }

    @Override
    public ClaimModel getClaimByClaimId(int claimId) {
        ClaimEntity claimEntity = service.findByClaimId(claimId);
        return new ClaimModel(claimEntity.getId(),
                claimEntity.getClaimId(),
                claimEntity.getPatientName(),
                claimEntity.getDiagnosis(),
                claimEntity.getClaimDate(),
                claimEntity.getClaimAmount());
    }

    @Override
    public void createClaim(ClaimModel claimModel) {
        // Convert ClaimModel to ClaimEntity and create the claim using service.create() from ClaimsDataService
        ClaimEntity claimEntity = new ClaimEntity(claimModel.getId(),
                claimModel.getClaimId(),
                claimModel.getPatientName(),
                claimModel.getDiagnosis(),
                claimModel.getClaimDate(),
                claimModel.getClaimAmount());
        service.create(claimEntity);
    }

    @Override
    public void updateClaim(ClaimModel claimModel) {
        ClaimEntity claimEntity = new ClaimEntity(claimModel.getId(),
                claimModel.getClaimId(),
                claimModel.getPatientName(),
                claimModel.getDiagnosis(),
                claimModel.getClaimDate(),
                claimModel.getClaimAmount());
        service.update(claimEntity);
    }

    @Override
    public void deleteClaim(ClaimModel claimModel) {
        ClaimEntity claimEntity = new ClaimEntity(claimModel.getId(),
                claimModel.getClaimId(),
                claimModel.getPatientName(),
                claimModel.getDiagnosis(),
                claimModel.getClaimDate(),
                claimModel.getClaimAmount());
        service.delete(claimEntity);
    }

    @Override
    public void init() {
        System.out.println("Hello from the ClaimsBusinessService.init()");
    }

    @Override
    public void destroy() {
        System.out.println("Hello from the ClaimsBusinessService.destroy()");
    }
}
