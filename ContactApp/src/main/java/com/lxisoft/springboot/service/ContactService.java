package com.lxisoft.springboot.service;




import com.lxisoft.springboot.entity.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    List<Contact> listAllContacts();
    List<Contact> searchContacts(String keyword);
    void saveContact(Contact contact);

    void deleteContact(int contact_id);

    Contact getContact(int contact_id);

    Page<Contact> findPaginated(int pageNo, int pageSize);


}
