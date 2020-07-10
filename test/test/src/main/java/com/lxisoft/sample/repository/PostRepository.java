package com.lxisoft.sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lxisoft.sample.entity.Post;

public interface PostRepository extends JpaRepository< Post,Long> {

}
