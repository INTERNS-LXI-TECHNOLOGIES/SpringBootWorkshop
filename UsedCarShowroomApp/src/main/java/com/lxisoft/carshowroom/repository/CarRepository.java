package com.lxisoft.carshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
