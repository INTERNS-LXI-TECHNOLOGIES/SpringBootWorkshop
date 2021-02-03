package com.lxisoft.repository;

import com.lxisoft.model.Answer;
import com.lxisoft.model.attendedExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.attendedExam;


@Repository
public interface examKey extends JpaRepository<Answer, Integer> {

}