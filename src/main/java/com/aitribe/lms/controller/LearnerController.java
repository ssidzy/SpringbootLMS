package com.aitribe.lms.controller;

import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearnerController {

    @Autowired
    private LearnerManagementService _learnerManagementService;

    @PostMapping("/learners")
    public Learner createLearner(@RequestBody Learner learner) {
        return _learnerManagementService.createLearner(learner);
    }

    @GetMapping("/learners")
    public List<Learner> getAllLearners() {
        return _learnerManagementService.getAllLearners();
    }

    @GetMapping("/learners/{learnerName}")
    public List<Learner> getLearnersByName(@PathVariable String learnerName) {
        return _learnerManagementService.getLearnersByName(learnerName);
    }
}
