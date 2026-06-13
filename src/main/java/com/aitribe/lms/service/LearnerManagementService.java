package com.aitribe.lms.service;

import com.aitribe.lms.entity.Learner;
import com.aitribe.lms.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
