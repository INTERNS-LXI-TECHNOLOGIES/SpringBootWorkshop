package com.lxisoft.mockexam.repository;

import com.lxisoft.mockexam.domain.Exam;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Exam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
