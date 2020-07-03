package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
