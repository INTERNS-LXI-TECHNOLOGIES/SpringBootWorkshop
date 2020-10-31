package com.lxisoft.repository;

import com.lxisoft.entity.Actor;
import com.lxisoft.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    
    List<Movie> findByName(String name);
    
}
