package com.lxisoft.MockExamProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.MockExamProject.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}