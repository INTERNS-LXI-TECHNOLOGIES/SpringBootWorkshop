package com.lxisoft.carshowroom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	Page<Car> findByModelContaining(String model, Pageable pageable);

	Page<Car> findByExpectedPriceBetween(Integer min, Integer max, Pageable pageable);

}