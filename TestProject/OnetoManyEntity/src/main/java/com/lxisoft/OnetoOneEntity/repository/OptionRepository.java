package com.lxisoft.OnetoOneEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.lxisoft.OnetoOneEntity.entity.Option;


@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

}