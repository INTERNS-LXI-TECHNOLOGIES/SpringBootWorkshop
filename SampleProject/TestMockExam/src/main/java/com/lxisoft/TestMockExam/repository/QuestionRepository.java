package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
