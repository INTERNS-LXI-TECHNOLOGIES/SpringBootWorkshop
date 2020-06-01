package com.lxisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.entity.Exam;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
