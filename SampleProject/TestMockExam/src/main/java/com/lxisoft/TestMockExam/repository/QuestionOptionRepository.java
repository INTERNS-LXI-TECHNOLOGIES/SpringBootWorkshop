package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption,Long> {
}
