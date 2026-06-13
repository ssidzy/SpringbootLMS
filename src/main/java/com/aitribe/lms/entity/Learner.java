package com.aitribe.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int learnerId;

    private String learnerName;
    private String learnerEmail;
    private String learnerPhone;


    public Learner() {}

    public Learner(String learnerName, String learnerEmail, String learnerPhone) {
        this.learnerName = learnerName;
        this.learnerEmail = learnerEmail;
        this.learnerPhone = learnerPhone;
    }

    public int getLearnerId() {
        return learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public String getLearnerEmail() {
        return learnerEmail;
    }

    public String getLearnerPhone() {
        return learnerPhone;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public void setLearnerEmail(String learnerEmail) {
        this.learnerEmail = learnerEmail;
    }

    public void setLearnerPhone(String learnerPhone) {
        this.learnerPhone = learnerPhone;
    }
}
