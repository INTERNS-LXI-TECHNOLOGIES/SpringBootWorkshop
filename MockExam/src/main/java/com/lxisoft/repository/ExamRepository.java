package com.lxisoft.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.entity.Exam;

@Repository
public interface ExamRepository extends CrudRepository <Exam, Long> { 
    List<Exam> findByName(String name); 
}