package com.godaddy.utils;

import com.godaddy.controller.ContactModel;
import com.godaddy.controller.ContactWrongMappingException;
import com.godaddy.service.ContactDomainModel;

import java.util.Arrays;

public class ModelMapper {

    public static ContactDomainModel toContactDomainModel(ContactModel contact) {
        ContactDomainModel contacts = new ContactDomainModel(contact.getName(), Arrays.toString(contact.getPhones()));
        return contacts;
    }


    public static ContactModel toContactModel(ContactDomainModel contacts) throws ContactWrongMappingException {
        if (contacts == null)
            //ToDo: add into Logger
            throw new ContactWrongMappingException("Nothing for parsing from Domain model to UI model.");

        return new ContactModel(contacts.getName(), contacts.getPhones().replace("[", "").replace("]", "").split(","));
    }

}
