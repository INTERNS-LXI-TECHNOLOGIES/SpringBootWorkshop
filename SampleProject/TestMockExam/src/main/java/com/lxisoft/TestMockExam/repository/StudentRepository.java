package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
