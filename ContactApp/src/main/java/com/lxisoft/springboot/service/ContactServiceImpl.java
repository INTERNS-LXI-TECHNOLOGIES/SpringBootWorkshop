package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepo;

    @Override

    public void listAllContacts(Integer pageNo, Model model) {

        Pageable pageable = PageRequest.of(pageNo - 1, 4, Sort.by("name"));
        Page<Contact> page = contactRepo.findAll(pageable);

        model.addAttribute("currentPage", page.getNumber() + 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("contactList", page.getContent());
        model.addAttribute("totalItems", page.getTotalElements());

    }

    public void searchContacts(Integer pageNo, String keyword, Model model) {
        Pageable pageable = PageRequest.of(pageNo - 1, 4, Sort.by("name"));
        Page<Contact> page = contactRepo.findByKeyword(keyword, pageable);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page.getNumber() + 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("contactList", page.getContent());
        model.addAttribute("totalItems", page.getTotalElements());

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

    }






}
