package com.lxisoft.MockExam.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lxisoft.entity.MockExam.MockEntity;

public interface MockRepository extends JpaRepository<MockEntity, Integer> 
{

}
