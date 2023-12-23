package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.UserModel;

@RestController
@RequestMapping("/api/users")
public class UserRestService {

	@Autowired
	private UserBusinessService service;
	
	@GetMapping(path="", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<UserModel> getUsersAsJson() {
		return service.getUsers();
	}
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id){
		
		try {
			UserModel user = service.getUserById(id);
			if (user == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/username/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username){
		
		try {
			UserModel user = service.getUserByUsername(username);
			if (user == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
