package com.lxisoftspringboot.service;




import com.lxisoftspringboot.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> listAllContacts();

    void saveContact(Contact contact);

    void deleteContact(int contact_id);

    Contact getContact(int contact_id);
}
