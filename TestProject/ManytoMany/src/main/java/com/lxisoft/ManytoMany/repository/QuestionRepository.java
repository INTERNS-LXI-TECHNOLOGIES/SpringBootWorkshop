package com.lxisoft.ManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.ManytoMany.model.Course;
import com.lxisoft.ManytoMany.model.Question;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Course findByName(String courseName);

	public Question getOne(long id);

	public Object findAll(long id);
}