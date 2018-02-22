package com.godaddy.service;

public interface ContactService {

    String addContact(ContactDomainModel contacts);

    String getAll();

    ContactDomainModel getByName(String name);

    ContactDomainModel getByID(String id);
}
