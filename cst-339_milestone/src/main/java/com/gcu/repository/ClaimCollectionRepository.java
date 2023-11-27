package com.gcu.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gcu.model.ClaimModel;

import jakarta.annotation.PostConstruct;

@Repository
public class ClaimCollectionRepository {

	private final List<ClaimModel> claims = new ArrayList<>();
	
	public ClaimCollectionRepository() {
		
	}
	
	public List<ClaimModel> findAll() {
		return claims;
	}
	
	public Optional<ClaimModel> findById(Integer id){
		return claims.stream().filter(c -> c.getClaimId().equals(id)).findFirst();
		
	}
	
	@PostConstruct
	private void init() {
		ClaimModel c = new ClaimModel(1, "John Doe", "Routine Checkup", LocalDate.now(), 200.0);
		claims.add(c);
		
	}
	
	
}
