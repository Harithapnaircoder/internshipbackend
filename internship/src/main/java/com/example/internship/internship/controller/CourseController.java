package com.example.internship.internship.controller;

import com.example.internship.internship.model.Course;

import com.example.internship.internship.model.Feedback;
import com.example.internship.internship.repository.CourseRepository;
import com.example.internship.internship.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        try {
            courseRepository.save(course);
            return ResponseEntity.ok("Course saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save course: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/courses")
    public ResponseEntity<?> getAllCourses() {
        try {
            return ResponseEntity.ok(courseRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve courses: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/courses/ou/{ou}")
    public ResponseEntity<?> getCoursesByOu(@PathVariable String ou) {
        try {
            List<Course> courses = courseRepository.findByOu(ou);
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve courses: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/course/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        try {
            return courseRepository.findById(id)
                    .map(course -> {
                        course.setCourseName(courseDetails.getCourseName());
                        course.setOu(courseDetails.getOu());
                        course.setTrainingType(courseDetails.getTrainingType());
                        course.setBatchCount(courseDetails.getBatchCount());
                        course.setTrainerName(courseDetails.getTrainerName());
                        course.setStatus(courseDetails.getStatus());
                        course.setFinalFeedback(courseDetails.getFinalFeedback());
                        course.setStartDate(courseDetails.getStartDate());
                        course.setEndDate(courseDetails.getEndDate());
                        courseRepository.save(course);
                        return ResponseEntity.ok("Course updated successfully!");
                    })
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update course: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        try {
            if (courseRepository.existsById(id)) {
                courseRepository.deleteById(id);
                return ResponseEntity.ok("Course deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete course: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/latest")
    public ResponseEntity<List<Course>> getLatestCompletedCoursesWithFeedback() {
        try {
            List<Object[]> results = courseRepository.findLatestCompletedCoursesWithFeedback();
            List<Course> courses = new ArrayList<>();

            for (Object[] result : results) {
                Long courseId = ((Number) result[0]).longValue();
                String courseName = (String) result[1];
                String status = (String) result[2];
                Date endDate = (Date) result[3];
                int finalScore = ((Number) result[4]).intValue();

                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                course.setStatus(status);
                course.setEndDate(endDate);
                course.setFinalFeedback(String.valueOf(finalScore)); // Assuming finalFeedback property is a String

                courses.add(course);
            }

            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
