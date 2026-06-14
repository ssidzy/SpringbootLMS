package com.aitribe.lms.controller;

import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.exception.LearnerNotFoundException;
import com.aitribe.lms.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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



//    @GetMapping("/learners")
//    public List<Learner> getAllLearners() {
//        return _learnerManagementService.getAllLearners();
//
//    }

    @GetMapping("/learners")
    public List<Learner> getLearnersByName(@RequestParam(value = "learnerName",required = false) String learnerName) {
        if(learnerName==null)
            return _learnerManagementService.getAllLearners();
        return _learnerManagementService.getLearnersByName(learnerName);
    }

    @GetMapping("/learners/{learnerId}")
    public Learner getLearnersById(@PathVariable long learnerId) throws LearnerNotFoundException {
        return _learnerManagementService.getLearnersById(learnerId);
    }

    @PostMapping("/test")
    public Learner test() {
        return _learnerManagementService.test();
    }

//    @GetMapping("/learners/{learnerName}")
//    public List<Learner> getLearnersByName(@PathVariable String learnerName) {
//        return _learnerManagementService.getLearnersByName(learnerName);
//    }
}
