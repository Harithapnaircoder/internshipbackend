package com.example.internship.internship.model;

import jakarta.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_id")
    private Long courseId;

    @Column(name="relate_rating")
    private int relateRating;

    @Column(name="delivery_rating")
    private int deliveryRating;

    @Column(name="confidence_rating")
    private int confidenceRating;

    @Column(name="trainer_rating")
    private int trainerRating;

    @Column(name="enjoyment")
    private String enjoyment;

    @Column(name="additional_comments")
    private String additionalComments;

    @Column(name="final_score")
    private int finalScore;

    // Getters and setters

    public Feedback() {
    }

    public Feedback(Long courseId, int relateRating, int deliveryRating, int confidenceRating, int trainerRating, String enjoyment, String additionalComments) {
        this.courseId = courseId;
        this.relateRating = relateRating;
        this.deliveryRating = deliveryRating;
        this.confidenceRating = confidenceRating;
        this.trainerRating = trainerRating;
        this.enjoyment = enjoyment;
        this.additionalComments = additionalComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getRelateRating() {
        return relateRating;
    }

    public void setRelateRating(int relateRating) {
        this.relateRating = relateRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public void setDeliveryRating(int deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    public int getConfidenceRating() {
        return confidenceRating;
    }

    public void setConfidenceRating(int confidenceRating) {
        this.confidenceRating = confidenceRating;
    }

    public int getTrainerRating() {
        return trainerRating;
    }

    public void setTrainerRating(int trainerRating) {
        this.trainerRating = trainerRating;
    }

    public String getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(String enjoyment) {
        this.enjoyment = enjoyment;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}
