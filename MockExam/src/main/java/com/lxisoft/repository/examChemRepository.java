package com.lxisoft.repository;

import com.lxisoft.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface examChemRepository extends JpaRepository<ExamChem,Integer> {
}
