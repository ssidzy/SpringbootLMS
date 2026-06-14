package com.aitribe.lms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cohortId;

    private String cohortName;
    private String cohortDescription;

    @ManyToMany
    private List<Learner> learners;

    public Cohort() {}

    public Cohort(String cohortName, String cohortDescription, List<Learner> learners) {
        this.learners = learners;
        this.cohortName = cohortName;
        this.cohortDescription = cohortDescription;
    }




    public int getCohortId() {
        return cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public String getCohortDescription() {
        return cohortDescription;
    }

    public List<Learner> getLearners() {
        return learners;
    }
}
