package com.lxisoft.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.sample.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
