package com.godaddy.repository;

import com.godaddy.controller.ContactWrongMappingException;
import com.godaddy.entity.ContactEntity;
import com.godaddy.service.ContactDomainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryMapper {

    public static List<ContactEntity> toEntityContact(ContactDomainModel contact) {
        List<ContactEntity> entityContacts = new ArrayList<ContactEntity>();
        for (String tel : contact.getPhones().replace("[", "").replace("]", "").split(",")) {
            entityContacts.add(new ContactEntity(contact.getName(), tel.trim()));
        }
        return entityContacts;
    }

    public static ContactDomainModel toContactDomainModel(List<ContactEntity> list) {

        ContactDomainModel contact = new ContactDomainModel();
        if (!list.isEmpty()) {
            contact.setName(list.get(0).getName());
            contact.setPhones(list.stream().map(ContactEntity::getPhone).collect(Collectors.toList()).toString());
        } else {
            //ToDo: add into Logger
            throw new ContactWrongMappingException("Nothing for parsing from DB Entity to Domain model.");
        }
        return contact;
    }

}
