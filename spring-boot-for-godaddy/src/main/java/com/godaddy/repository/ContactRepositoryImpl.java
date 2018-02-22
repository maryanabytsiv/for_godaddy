package com.godaddy.repository;

import com.godaddy.entity.ContactEntity;
import com.godaddy.service.ContactDomainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @Autowired
    private ContactCrudRepository contactRepository;

    @Override
    public String addContact(ContactDomainModel contacts) {
        contactRepository.save(RepositoryMapper.toEntityContact(contacts));
        return "Saved";
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public ContactDomainModel getByName(String name) {
        return RepositoryMapper.toContactDomainModel(contactRepository.findByName(name));
    }

    @Override
    public ContactDomainModel getByID(String id) {
        List<ContactEntity> contactEntityList = new ArrayList<>();
        if (contactRepository.findOne(id) == null) {
            return RepositoryMapper.toContactDomainModel(contactEntityList);
        }
        contactEntityList.add(contactRepository.findOne(id));
        return RepositoryMapper.toContactDomainModel(contactEntityList);
    }
}

