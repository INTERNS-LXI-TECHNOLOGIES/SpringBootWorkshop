package com.lxisoft.vegetablestore.repository;


import com.lxisoft.vegetablestore.entity.VegetableStoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VegetableStoreUserRepository extends JpaRepository<VegetableStoreUser, String> {

}

