package com.lxisoft.vegetablestore.repository;

import com.lxisoft.vegetablestore.entity.Category;
import com.lxisoft.vegetablestore.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT vegetable FROM Vegetable vegetable WHERE cate_id='?'")
    List<Vegetable> findVegetableInCategory(int id);

}
