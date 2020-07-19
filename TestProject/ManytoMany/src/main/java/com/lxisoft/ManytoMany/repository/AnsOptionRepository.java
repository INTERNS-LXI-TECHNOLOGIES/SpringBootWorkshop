package com.lxisoft.ManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.ManytoMany.model.AnsOption;
import com.lxisoft.ManytoMany.model.Course;



@Repository
public interface AnsOptionRepository extends JpaRepository<AnsOption, Integer> {

	public Course findByName(String courseName);
}