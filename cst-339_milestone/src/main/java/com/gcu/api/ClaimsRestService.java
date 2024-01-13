package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ClaimsBusinessServiceInterface;
import com.gcu.model.ClaimModel;

@RestController
@RequestMapping("/api/claims")
public class ClaimsRestService {

	@Autowired
	private ClaimsBusinessServiceInterface service;

	@GetMapping(path = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getAllClaims() {
		try {
			List<ClaimModel> claims = service.getClaims();
			if (claims.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(claims, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/id={id}")
	public ResponseEntity<?> getClaimById(@PathVariable("id") String id) {
		try {
			ClaimModel claim = service.getClaimById(id);
			if (claim == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(claim, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/claimid={id}")
	public ResponseEntity<?> getClaim(@PathVariable("id") int id) {
		try {
			ClaimModel claim = service.getClaimByClaimId(id);
			if (claim == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(claim, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
