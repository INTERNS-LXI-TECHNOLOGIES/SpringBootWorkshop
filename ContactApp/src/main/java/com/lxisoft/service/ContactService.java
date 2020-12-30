package com.lxisoft.service;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ContactService {


    @Autowired
    private AddressBookRepository addressBookRepository;

    public Contact getContactById(int id)
    {

       return addressBookRepository.getOne(id);

    }
    public void saveContact(Contact contact)
    {
        addressBookRepository.save(contact);
    }

    public List<Contact> viewData()
    {
       return addressBookRepository.findAll();

    }

    public void delete(int id)
    {
        addressBookRepository.deleteById(id);
    }

    public void add(Contact contact)
    {
        addressBookRepository.save(contact);
    }



}