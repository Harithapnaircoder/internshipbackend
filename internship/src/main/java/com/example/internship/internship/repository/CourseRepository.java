package com.example.internship.internship.repository;

import com.example.internship.internship.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseName(String courseName);

    List<Course> findByOu(String ou);

    @Query(value = "SELECT c.course_id, c.course_name, c.status, c.end_date, COALESCE(f.final_score, 0) " +
            "FROM course c " +
            "LEFT JOIN feedback f ON c.course_id = f.course_id " +
            "WHERE c.status = 'completed' " +
            "ORDER BY c.end_date DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Object[]> findLatestCompletedCoursesWithFeedback();


}
