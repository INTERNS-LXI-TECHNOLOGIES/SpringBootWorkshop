package com.lxisoft.carshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.CarUser;

@Repository
public interface CarUserRepository extends JpaRepository<CarUser, String> {

}
