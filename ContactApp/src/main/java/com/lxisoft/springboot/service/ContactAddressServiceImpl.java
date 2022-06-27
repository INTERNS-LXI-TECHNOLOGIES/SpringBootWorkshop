package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.ContactAddress;
import com.lxisoft.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactAddressServiceImpl implements ContactAddressService{

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public void saveContactAddress(ContactAddress contactAddress) {
     addressRepo.save(contactAddress);
    }

    @Override
    public ContactAddress getContactAddress(Integer address_id) {

        return null;
    }

    @Override
    public void deleteContactAddress(Integer address_id) {

    }
}
