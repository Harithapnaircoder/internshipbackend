package com.example.internship.internship.repository;

import com.example.internship.internship.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);
    List<Course> findByOu(String ou);  // New method to find courses by OU
}
