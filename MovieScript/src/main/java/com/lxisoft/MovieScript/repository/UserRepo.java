package com.lxisoft.moviescript.repository;

import org.springframework.data.repository.CrudRepository;

import com.lxisoft.moviescript.model.User;

public interface UserRepo extends CrudRepository<User,Integer> 
{

}
