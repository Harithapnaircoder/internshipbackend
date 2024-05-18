package com.example.internship.internship.repository;
import com.example.internship.internship.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SignupRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}