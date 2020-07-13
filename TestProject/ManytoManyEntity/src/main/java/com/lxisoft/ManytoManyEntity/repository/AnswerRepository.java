package com.lxisoft.ManytoManyEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.ManytoManyEntity.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}