package com.lxisoft.repository;

import java.util.List;

import com.lxisoft.model.Dialogue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("DialogueReppo")
public interface DialogueReppo extends JpaRepository<Dialogue,Integer>
{


}