package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.ContactAddress;
import com.lxisoft.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

/*
        return addressRepo.findById(address_id).get();
*/
        Optional<ContactAddress> optional = addressRepo.findById(address_id);
        ContactAddress address = null;
        if (optional.isPresent()) {
            address = optional.get();
        } else {
            throw new RuntimeException(" ContactAddress not found for id :: " + address_id);
        }
        return address;

    }

    @Override
    public void deleteContactAddress(Integer addressId) {
    addressRepo.deleteById(addressId);
    }
}
