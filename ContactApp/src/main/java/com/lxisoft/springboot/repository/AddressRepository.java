package com.lxisoft.springboot.repository;


import com.lxisoft.springboot.entity.ContactAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<ContactAddress, Integer> {
    Page<ContactAddress> findAll(Pageable pageable);
}
