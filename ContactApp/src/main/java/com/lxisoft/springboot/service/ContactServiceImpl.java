package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepo;

    @Override

    public List<Contact> listAllContacts(String keyword) {
        if (keyword != null) {
            return contactRepo.search(keyword);
        }
        return contactRepo.findAll();
       // return contactRepo.findAll();
    }

    @Override

    public void saveContact(Contact contact) {
        contactRepo.save(contact);
    }

    @Override

    public void deleteContact(int contact_id) {
        contactRepo.deleteById(contact_id);
    }

    @Override

    public Contact getContact(int contact_id) {
        Optional< Contact > optional = contactRepo.findById(contact_id);
        Contact contact = null;
        if (optional.isPresent()) {
            contact = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + contact_id);
        }
        return contact;
       // return contactRepo.findById(contact_id).get();
    }
}
