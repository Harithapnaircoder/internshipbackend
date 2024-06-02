package com.example.internship.internship.repository;

import com.example.internship.internship.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByCourseid(Long courseid);
}
