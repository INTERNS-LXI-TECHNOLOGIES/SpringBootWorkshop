package com.lxisoft.springboot.repository;

import com.lxisoft.springboot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<AppUser, String> {
}
