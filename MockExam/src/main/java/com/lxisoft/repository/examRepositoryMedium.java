package com.lxisoft.repository;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface examRepositoryMedium extends JpaRepository<ExamMedium,Integer> {
}
