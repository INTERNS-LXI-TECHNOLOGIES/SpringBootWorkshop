package com.lxisoft.springboot.service;




import com.lxisoft.springboot.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> listAllContacts(String keyword);

    void saveContact(Contact contact);

    void deleteContact(int contact_id);

    Contact getContact(int contact_id);
}
