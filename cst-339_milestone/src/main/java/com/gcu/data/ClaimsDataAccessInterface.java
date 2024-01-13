package com.gcu.data;

public interface ClaimsDataAccessInterface<T> {
	public T findByClaimId(int claimId);

}
