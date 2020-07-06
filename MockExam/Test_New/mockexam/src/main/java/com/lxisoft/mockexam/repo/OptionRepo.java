package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OptionRepo extends JpaRepository<Options,Integer> {


}
