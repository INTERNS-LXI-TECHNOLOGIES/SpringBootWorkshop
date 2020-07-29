package com.lxisoft.MockexamSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lxisoft.MockexamSecurity.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}