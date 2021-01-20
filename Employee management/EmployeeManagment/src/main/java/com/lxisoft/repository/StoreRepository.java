package com.lxisoft.repository;

import com.lxisoft.entity.Store;
import com.lxisoft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    
    List<User> findByName(String name);


    
}
