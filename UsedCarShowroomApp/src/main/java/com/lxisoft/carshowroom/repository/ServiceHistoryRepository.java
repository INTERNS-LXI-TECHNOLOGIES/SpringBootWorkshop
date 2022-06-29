package com.lxisoft.carshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.ServiceHistory;

@Repository
public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory, Integer> {
}