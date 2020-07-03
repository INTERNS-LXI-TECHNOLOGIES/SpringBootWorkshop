package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
