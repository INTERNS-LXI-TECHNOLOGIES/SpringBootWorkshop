package com.lxisoft.vegetablestore.repository;


import com.lxisoft.vegetablestore.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VegetableStoreRepository extends JpaRepository<Vegetable, Integer> {

@Query("SELECT vegetable FROM Vegetable vegetable WHERE name LIKE %?1%")
List<Vegetable> search( String keyword);

}