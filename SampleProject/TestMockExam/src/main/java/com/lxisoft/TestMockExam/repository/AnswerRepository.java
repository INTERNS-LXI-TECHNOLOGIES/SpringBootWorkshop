package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
