package com.lxisoft.repository;

import java.util.List;

import com.lxisoft.entity.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    
    List<Actor> findByName(String name);
    
}
