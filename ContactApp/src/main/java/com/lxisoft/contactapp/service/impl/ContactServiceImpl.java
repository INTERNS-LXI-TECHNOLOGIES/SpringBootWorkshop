package com.lxisoft.contactapp.service.impl;

import com.lxisoft.contactapp.domain.Contact;
import com.lxisoft.contactapp.repository.ContactRepository;
import com.lxisoft.contactapp.service.ContactService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Contact}.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Request to save Contact : {}", contact);
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Request to save Contact : {}", contact);
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> partialUpdate(Contact contact) {
        log.debug("Request to partially update Contact : {}", contact);

        return contactRepository
            .findById(contact.getId())
            .map(existingContact -> {
                if (contact.getContactName() != null) {
                    existingContact.setContactName(contact.getContactName());
                }
                if (contact.getContactNumber() != null) {
                    existingContact.setContactNumber(contact.getContactNumber());
                }
                if (contact.getEmail() != null) {
                    existingContact.setEmail(contact.getEmail());
                }

                return existingContact;
            })
            .map(contactRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Contact> findAll(Pageable pageable) {
        log.debug("Request to get all Contacts");
        return contactRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findOne(Long id) {
        log.debug("Request to get Contact : {}", id);
        return contactRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Contact : {}", id);
        contactRepository.deleteById(id);
    }
}
