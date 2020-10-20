package com.lxisoft.repository;

import com.lxisoft.entity.Actor;
import com.lxisoft.entity.Dialogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialogueRepository extends CrudRepository<Dialogue, Long>
{
    
    List<Dialogue> findByName(String name);
    
}
