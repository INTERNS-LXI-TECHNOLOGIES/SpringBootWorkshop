package com.lxisoft.mockexam.repository;

import com.lxisoft.mockexam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ExamRepo")
public interface ExamRepo extends JpaRepository<Exam,Integer>
{

}
