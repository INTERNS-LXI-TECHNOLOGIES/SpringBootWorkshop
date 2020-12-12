package com.lxisoft.repository;

import java.util.List;

import com.lxisoft.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("UserReppo")
public interface UserReppo extends JpaRepository<User,Integer>
{


}