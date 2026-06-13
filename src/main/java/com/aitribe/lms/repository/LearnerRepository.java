package com.aitribe.lms.repository;

import com.aitribe.lms.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {

    public List<Learner> findByLearnerName(String learnerName);
}
