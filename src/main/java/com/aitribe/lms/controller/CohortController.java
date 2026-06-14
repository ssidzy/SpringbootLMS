package com.aitribe.lms.controller;

import com.aitribe.lms.entity.Cohort;
import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.exception.CohortNotFoundException;
import com.aitribe.lms.exception.LearnerNotFoundException;
import com.aitribe.lms.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CohortController {

    @Autowired
    private LearnerManagementService _learnerManagementService;

    @PostMapping("/cohort")
    public Cohort createCohort(@RequestBody Cohort cohort) {
        // In a real application, you would save the cohort to a database here
        return _learnerManagementService.createCohort(cohort); // For demonstration, we simply return the received cohort
    }

    @PostMapping("/assignLearnerToCohort")
    public Cohort assignLearnerToCohort(@RequestParam("cohortId") long cohortId, @RequestParam("learnerId") long learnerId) throws CohortNotFoundException, LearnerNotFoundException {
        return _learnerManagementService.assignLearnerToCohort(cohortId, learnerId);
    }


}
