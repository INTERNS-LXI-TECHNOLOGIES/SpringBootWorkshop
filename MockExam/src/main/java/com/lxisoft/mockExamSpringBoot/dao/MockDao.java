package com.lxisoft.mockExamSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.mockExamSpringBoot.entity.MockEntity;

public interface MockDao extends JpaRepository<MockEntity, Integer> {

}
