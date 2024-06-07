package com.example.internship.internship.controller;

import com.example.internship.internship.model.Course;
import com.example.internship.internship.model.User;
import com.example.internship.internship.repository.CourseRepository;
import com.example.internship.internship.repository.SignupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                List<Course> courses = courseRepository.findByCourseName(userData.getCourse());
                if (courses != null && !courses.isEmpty()) {
                    List<Map<String, String>> courseDetails = courses.stream().map(course -> {
                        Map<String, String> courseMap = new HashMap<>();
                        courseMap.put("courseId", course.getCourseId().toString());
                        courseMap.put("courseName", course.getCourseName());
                        courseMap.put("status", course.getStatus());
                        courseMap.put("ou", course.getOu());
                        courseMap.put("Batch count", String.valueOf(course.getBatchCount()));
                        courseMap.put("Trainer name", course.getTrainingType());
                        courseMap.put("startDate", course.getStartDate().toString());
                        courseMap.put("endDate", course.getEndDate().toString());
                        return courseMap;
                    }).collect(Collectors.toList());

                    response.put("courses", courseDetails);
                } else {
                    response.put("status", "error");
                    response.put("message", "No courses found for the user");
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
