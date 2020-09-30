package com.lxisoft.repository;

import java.util.List;

import com.lxisoft.model.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("ActorReppo")
public interface ActorReppo extends JpaRepository<Actor,Integer>
{


}-