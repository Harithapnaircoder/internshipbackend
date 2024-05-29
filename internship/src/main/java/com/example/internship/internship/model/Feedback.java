package com.example.internship.internship.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private int courseid;

    @Column(name = "relevant_and_helpful")
    private int relevantAndHelpful;

    @Column(name = "clear_and_understandable")
    private int clearAndUnderstandable;

    @Column(name = "confident_in_applying")
    private int confidentInApplying;

    @Column(name = "trainer_rating")
    private int trainerRating;

    @Column(name = "enjoyment")
    private String enjoyment;

    @Column(name = "additional_comments")
    private String additionalComments;

    @Column(name = "final_score")
    private int finalScore;

    // Constructors, getters, and setters

    public Feedback(Long id, int courseid, int relevantAndHelpful, int clearAndUnderstandable, int confidentInApplying, int trainerRating, String enjoyment, String additionalComments, int finalScore) {
        this.id = id;
        this.courseid = courseid;
        this.relevantAndHelpful = relevantAndHelpful;
        this.clearAndUnderstandable = clearAndUnderstandable;
        this.confidentInApplying = confidentInApplying;
        this.trainerRating = trainerRating;
        this.enjoyment = enjoyment;
        this.additionalComments = additionalComments;
        this.finalScore = finalScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getRelevantAndHelpful() {
        return relevantAndHelpful;
    }

    public void setRelevantAndHelpful(int relevantAndHelpful) {
        this.relevantAndHelpful = relevantAndHelpful;
    }

    public int getClearAndUnderstandable() {
        return clearAndUnderstandable;
    }

    public void setClearAndUnderstandable(int clearAndUnderstandable) {
        this.clearAndUnderstandable = clearAndUnderstandable;
    }

    public int getConfidentInApplying() {
        return confidentInApplying;
    }

    public void setConfidentInApplying(int confidentInApplying) {
        this.confidentInApplying = confidentInApplying;
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

    public Feedback() {

    }

}
