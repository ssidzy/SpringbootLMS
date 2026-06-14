package com.aitribe.lms.service;

import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.exception.LearnerNotFoundException;
import com.aitribe.lms.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LearnerManagementService {

    @Autowired
    private LearnerRepository _learnerRepository;

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
}
