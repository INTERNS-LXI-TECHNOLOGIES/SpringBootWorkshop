package com.lxisoft.springboot.service;




import com.lxisoft.springboot.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.List;

public interface ContactService {
    void listAllContacts(Integer pageNo,  Model model);
/*    List<Contact> searchContacts(String keyword);*/
    void searchContacts(Integer pageNo, String keyword, Model model);
    void saveContact(Contact contact);

    void deleteContact(int contactId);

    Contact getContact(int contactId);

    List<Contact> getContacts();

/*    Page<Contact> findPaginated(int pageNo, int pageSize);*/


}
