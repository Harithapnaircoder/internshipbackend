package com.example.internship.internship.controller;

import com.example.internship.internship.model.Course;
import com.example.internship.internship.model.User;
import com.example.internship.internship.repository.CourseRepository;
import com.example.internship.internship.repository.SignupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SigninController {

    private final SignupRepository userRepository;
    private final CourseRepository courseRepository;

    public SigninController(SignupRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginCheckUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        User userData = userRepository.findByEmail(email);
        Map<String, Object> response = new HashMap<>();

        if (userData != null && userData.getPassword().equals(password)) {
            response.put("status", "success");
            response.put("role", userData.getRole());
            response.put("userId", userData.getId().toString());

            if ("student".equalsIgnoreCase(userData.getRole())) {
                Course course = courseRepository.findByCourseName(userData.getCourse());
                if (course != null) {
                    response.put("course", userData.getCourse());
                    response.put("courseId", course.getCourseId().toString());
                } else {
                    response.put("status", "error");
                    response.put("message", "Course not found");
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                }
            }

            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
