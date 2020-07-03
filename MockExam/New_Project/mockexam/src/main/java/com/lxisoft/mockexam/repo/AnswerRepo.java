package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface AnswerRepo extends JpaRepository<Answer,Integer> {


}
