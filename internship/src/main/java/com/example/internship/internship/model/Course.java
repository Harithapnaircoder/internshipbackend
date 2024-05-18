package com.example.internship.internship.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "ou")
    private String ou; // Organizational Unit

    @Column(name = "training_type")
    private String trainingType;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "batch_count")
    private int batchCount;

    @Column(name = "trainer_name")
    private String trainerName;

    @Column(name = "status")
    private String status;

    @Column(name = "final_feedback")
    private int finalFeedback;

    // Getters and setters

    public Course() {
    }

    public Course(String courseName, String ou, String trainingType, Date startDate, Date endDate, int batchCount, String trainerName, String status, int finalFeedback) {
        this.courseName = courseName;
        this.ou = ou;
        this.trainingType = trainingType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.batchCount = batchCount;
        this.trainerName = trainerName;
        this.status = status;
        this.finalFeedback = finalFeedback;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFinalFeedback() {
        return finalFeedback;
    }

    public void setFinalFeedback(int finalFeedback) {
        this.finalFeedback = finalFeedback;
    }
}
