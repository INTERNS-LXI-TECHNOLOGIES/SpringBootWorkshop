package com.lxisoft.carshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}