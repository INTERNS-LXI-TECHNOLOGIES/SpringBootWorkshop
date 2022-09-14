package com.lxisoft.vegetablestore.repository;

import com.lxisoft.vegetablestore.vegetable.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableStoreRepository extends JpaRepository<Vegetable, Integer> {

@Query("SELECT vegetable FROM Vegetable vegetable WHERE name LIKE %?1%")
List<Vegetable> search( String keyword);

}