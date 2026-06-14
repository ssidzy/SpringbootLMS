package com.aitribe.lms.service;

import com.aitribe.lms.entity.Cohort;
import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.exception.CohortNotFoundException;
import com.aitribe.lms.exception.LearnerNotFoundException;
import com.aitribe.lms.repository.CohortRepository;
import com.aitribe.lms.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LearnerManagementService {

    @Autowired
    private LearnerRepository _learnerRepository;

    @Autowired
    private CohortRepository _cohortRepository;

    public Learner createLearner(Learner learner) {
        return _learnerRepository.save(learner);
    }

    public List<Learner> getAllLearners() {
        return _learnerRepository.findAll();
    }

    public List<Learner> getLearnersByName(String learnerName) {
        return _learnerRepository.findByLearnerName(learnerName);
    }

//    public Learner getLearnersById(long learnerId) {
//        return _learnerRepository.findById(learnerId).get();
//    }

    public Learner getLearnersById(long learnerId) throws LearnerNotFoundException {

        Optional<Learner> learnerOptional = _learnerRepository.findById(learnerId);

        if(learnerOptional.isPresent()) {
            return _learnerRepository.findById(learnerId).get();
        }

        throw new LearnerNotFoundException("Learner with id " + learnerId + " not found");
    }

    public Learner test() {
        return _learnerRepository.findById(1L).get();
    }


    public Cohort createCohort(Cohort cohort) {
        return _cohortRepository.save(cohort);
    }

    public Cohort assignLearnerToCohort(long cohortId, long learnerId) throws CohortNotFoundException, LearnerNotFoundException {

        Optional<Cohort> cohortOptional = _cohortRepository.findById(cohortId);
        if(!cohortOptional.isPresent()) {
            throw new CohortNotFoundException("Cohort with id " + cohortId + " not found");
        }

        Cohort fetchedCohort = cohortOptional.get();

        Optional<Learner> learnerOptional = _learnerRepository.findById(learnerId);
        if(!learnerOptional.isPresent()) {
            throw new LearnerNotFoundException("Learner with id " + learnerId + " not found");
        }

        Learner fetchedLearner = learnerOptional.get();

        fetchedCohort.getLearners().add(fetchedLearner);

        // Step 1: Get the learners list
        //List<Learner> learnersList = fetchedCohort.getLearners();
        // Step 2: Add the learner to the list
        //learnersList.add(fetchedLearner);

        return _cohortRepository.save(fetchedCohort);

    }
}
