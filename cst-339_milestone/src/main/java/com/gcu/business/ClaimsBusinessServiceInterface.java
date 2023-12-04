package com.gcu.business;

import java.util.List;

import com.gcu.model.ClaimModel;

public interface ClaimsBusinessServiceInterface {

	public void test();

	public List<ClaimModel> getClaims();
	
	public void createClaim(ClaimModel claimModel);

	public void init();

	public void destroy();
}

