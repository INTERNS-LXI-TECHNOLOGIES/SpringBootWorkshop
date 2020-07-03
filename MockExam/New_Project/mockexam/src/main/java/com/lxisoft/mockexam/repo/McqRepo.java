package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.MCQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface McqRepo extends JpaRepository<MCQ,Integer> {

    void saveAll();
}
