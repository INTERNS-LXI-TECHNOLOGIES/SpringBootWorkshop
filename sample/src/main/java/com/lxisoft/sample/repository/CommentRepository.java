package com.lxisoft.sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.sample.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
