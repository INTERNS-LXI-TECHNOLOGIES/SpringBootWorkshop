package com.lxisoft.vegetablestore.repository;

import com.lxisoft.vegetablestore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateRepository extends JpaRepository<Category, Integer> {
}
