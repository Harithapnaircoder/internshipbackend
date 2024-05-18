package com.example.internship.internship.repository;

import com.example.internship.internship.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
