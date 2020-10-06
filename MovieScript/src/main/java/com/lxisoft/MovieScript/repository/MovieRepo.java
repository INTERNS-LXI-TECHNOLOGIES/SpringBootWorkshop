package com.lxisoft.moviescript.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.moviescript.model.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer>  
{

}
