package com.lxisoft.MockExam.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.MockExam.entity.*;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long> {
    
    List<Exam> findByQuestion(String Question);
    
}
