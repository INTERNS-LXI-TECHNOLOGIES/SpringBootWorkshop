package com.lxisoft.carshowroom.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.carshowroom.entity.ServiceHistory;

@Repository
public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory, Date> {
}