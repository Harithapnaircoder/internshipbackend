package com.example.internship.internship.model;

import java.util.List;

public class CourseFeedbackDTO {
    private Course course;
    private List<Feedback> feedbacks;

    public CourseFeedbackDTO(Course course, List<Feedback> feedbacks) {
        this.course = course;
        this.feedbacks = feedbacks;
    }

    // Getters and setters

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
