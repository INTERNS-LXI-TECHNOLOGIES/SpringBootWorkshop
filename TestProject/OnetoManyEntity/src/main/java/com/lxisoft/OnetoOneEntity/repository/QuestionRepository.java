package com.lxisoft.OnetoOneEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.lxisoft.OnetoOneEntity.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	


}