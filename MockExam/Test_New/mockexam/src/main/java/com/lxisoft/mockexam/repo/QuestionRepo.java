package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface QuestionRepo extends JpaRepository<Question,Integer> {



}
