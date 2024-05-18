
package com.example.internship.internship.controller;

import com.example.internship.internship.model.User;
import com.example.internship.internship.repository.SignupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SigninController {

    private final SignupRepository userRepository;

    public SigninController(SignupRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginCheckUser(@RequestBody User user) {
        User userData = userRepository.findByEmail(user.getEmail());
        Map<String, String> response = new HashMap<>();

        if (userData != null && userData.getPassword().equals(user.getPassword())) {
            response.put("status", "success");
            response.put("role", userData.getRole());
            response.put("userId", userData.getId().toString());
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
