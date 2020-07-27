package com.lxisoft.MockexamProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.MockexamProject.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}