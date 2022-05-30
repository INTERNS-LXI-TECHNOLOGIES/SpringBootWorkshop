package com.lxisoftspringboot.repository;

import com.lxisoftspringboot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<AppUser, String> {
}
