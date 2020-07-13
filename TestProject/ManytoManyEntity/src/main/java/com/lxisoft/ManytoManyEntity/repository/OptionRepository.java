package com.lxisoft.ManytoManyEntity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.ManytoManyEntity.entity.AnsOption;

@Repository
public interface OptionRepository extends JpaRepository<AnsOption, Long>{

}