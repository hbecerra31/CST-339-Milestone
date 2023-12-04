package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ClaimsDataService;
import com.gcu.entity.ClaimEntity;
import com.gcu.model.ClaimModel;

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
		
		// Get all the Entity Orders
		List<ClaimEntity> claimEntity = service.findAll();

		// Iterate over the Entity Orders and create a list of Domain Orders
		List<ClaimModel> claimsDomain = new ArrayList<ClaimModel>();
		for (ClaimEntity entity : claimEntity) {
			claimsDomain.add(new ClaimModel(entity.getClaimId(), 
											entity.getPatientName(), 
											entity.getDiagnosis(),
											entity.getClaimDate(), 
											entity.getClaimAmount()));
		}

		// Return list of Domain Orders
		return claimsDomain;
	}
	
	@Override
	public void createClaim(ClaimModel claimModel) {
		ClaimEntity claimEntity = new ClaimEntity(claimModel.getClaimId(),
												  claimModel.getPatientName(),
												  claimModel.getDiagnosis(),
												  claimModel.getClaimDate(),
												  claimModel.getClaimAmount());
		service.create(claimEntity);
	}

	@Override
	public void init() {
		System.out.println("Hello from the OrdersBusinessService.init()");

	}

	@Override
	public void destroy() {
		System.out.println("Hello from the OrdersBusinessService.destroy()");

	}

	
}
