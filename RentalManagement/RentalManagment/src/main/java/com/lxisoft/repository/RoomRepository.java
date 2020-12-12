package com.lxisoft.repository;

import com.lxisoft.entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    
    List<Room> findByName(String name);
    
}
