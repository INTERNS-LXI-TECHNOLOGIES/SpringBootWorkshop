package com.lxisoft.OnetoOneEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.lxisoft.OnetoOneEntity.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	


}