package com.lxisoft.vegetablestore.repository;

import com.lxisoft.vegetablestore.entity.Category;
import com.lxisoft.vegetablestore.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT vegetables FROM Category cat  WHERE cat.id =?1")
    List<Vegetable> findAllVegetableInCate_id(int id);
}
