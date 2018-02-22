package com.godaddy.repository;

import com.godaddy.service.ContactDomainModel;

public interface ContactRepository {

    String addContact(ContactDomainModel contacts);

    //ToDo not implemented
    String getAll();

    ContactDomainModel getByName(String name);

    ContactDomainModel getByID(String id);
}
