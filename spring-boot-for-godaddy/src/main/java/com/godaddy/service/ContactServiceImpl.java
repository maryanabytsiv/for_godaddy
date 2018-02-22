package com.godaddy.service;


import com.godaddy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public String addContact(ContactDomainModel contacts) {
        contactRepository.addContact(contacts);
        return "Contact saved";
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public ContactDomainModel getByName(String name) {
        return contactRepository.getByName(name);
    }

    @Override
    public ContactDomainModel getByID(String id) {
        return contactRepository.getByID(id);
    }
}