package com.lxisoft.MockExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.MockExam.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
