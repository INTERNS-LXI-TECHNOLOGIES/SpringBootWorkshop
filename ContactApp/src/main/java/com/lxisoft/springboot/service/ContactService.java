package com.lxisoft.springboot.service;




import com.lxisoft.springboot.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.List;

public interface ContactService {
    void listAllContacts(Integer pageNo, String keyword, Model model);
/*    List<Contact> searchContacts(String keyword);*/
    void saveContact(Contact contact);

    void deleteContact(int contact_id);

    Contact getContact(int contact_id);

/*    Page<Contact> findPaginated(int pageNo, int pageSize);*/


}
