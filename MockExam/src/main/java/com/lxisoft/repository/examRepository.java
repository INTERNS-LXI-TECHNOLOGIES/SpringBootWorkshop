package com.lxisoft.repository;

import com.lxisoft.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface examRepository extends JpaRepository<Exam,Integer> {
}
