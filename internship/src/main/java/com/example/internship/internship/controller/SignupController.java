package com.example.internship.internship.controller;

import com.example.internship.internship.model.User;
import com.example.internship.internship.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Check if the email already exists in the database
        User existingUser = signupRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            // If the email already exists, return a conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email address already in use");
        } else {
            // Email does not exist, proceed with signup
            signupRepository.save(user);
            // Return response with signup success message and role in two lines
            return ResponseEntity.ok("Signup successful\nRole: " + user.getRole());
        }
    }

}
