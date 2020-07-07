package com.lxisoft.ManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.lxisoft.ManytoMany.model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}