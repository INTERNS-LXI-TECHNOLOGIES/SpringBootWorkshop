package com.lxisoft.sample1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.sample1.entity.Exam;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
