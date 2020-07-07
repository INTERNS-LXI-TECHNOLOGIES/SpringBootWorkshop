package com.lxisoft.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.lxisoft.jpa.Model.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}