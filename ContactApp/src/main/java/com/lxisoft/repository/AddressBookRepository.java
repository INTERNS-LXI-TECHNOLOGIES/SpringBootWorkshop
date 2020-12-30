package com.lxisoft.repository;

import com.lxisoft.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("AddressBookRepository")
@Repository
public interface AddressBookRepository extends JpaRepository<Contact,Integer> {



}


