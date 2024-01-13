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

import com.gcu.business.UserBusinessService;
import com.gcu.model.UserModel;

/**
 * RESTful API controller for managing users in the CST 339 Milestone application.
 * This class handles HTTP requests related to users.
 * 
 * @author Hugo Becerra
 */
@RestController
@RequestMapping("/api/users")
public class UserRestService {

    @Autowired
    private UserBusinessService service;

    /**
     * Endpoint to retrieve all users.
     * 
     * @return ResponseEntity with the list of users or an appropriate HTTP status.
     */
    @GetMapping(path = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserModel> users = service.getUsers();
            if (users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint to retrieve a user by their ID.
     * 
     * @param id The ID of the user to retrieve.
     * @return ResponseEntity with the requested user or an appropriate HTTP status.
     */
    @GetMapping(path = "/id={id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {

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

    /**
     * Endpoint to retrieve a user by their username.
     * 
     * @param username The username of the user to retrieve.
     * @return ResponseEntity with the requested user or an appropriate HTTP status.
     */
    @GetMapping(path = "/username={username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {

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
