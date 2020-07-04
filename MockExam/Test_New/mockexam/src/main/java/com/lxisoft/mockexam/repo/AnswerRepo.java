package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AnswerRepo extends JpaRepository<Answer,Integer> {
}
