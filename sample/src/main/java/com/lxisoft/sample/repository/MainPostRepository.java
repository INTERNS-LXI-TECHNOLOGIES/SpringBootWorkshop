package com.lxisoft.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.sample.entity.MainPost;

@Repository
public interface MainPostRepository extends JpaRepository<MainPost,Long>{

}
