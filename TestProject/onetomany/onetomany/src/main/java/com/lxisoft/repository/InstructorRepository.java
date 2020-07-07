package com.lxisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}

