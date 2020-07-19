package com.lxisoft.ManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.ManytoMany.model.Answer;
import com.lxisoft.ManytoMany.model.Course;



@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	
}