package com.lxisoft.springboot.repository;

import com.lxisoft.springboot.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("SELECT contact FROM Contact contact WHERE CONCAT(contact.name, ' ', contact.email, ' ', contact.address, ' ', contact.phone) LIKE %?1%")
    Page< Contact > findByKeyword(String keyword,Pageable pageable);

    Page< Contact > findAll(Pageable pageable);


}
