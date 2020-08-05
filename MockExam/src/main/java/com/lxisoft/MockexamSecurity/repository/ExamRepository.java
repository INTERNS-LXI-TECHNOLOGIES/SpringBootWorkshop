package com.lxisoft.MockexamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.MockexamSecurity.model.Exam;



@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}