package com.godaddy.repository;

import com.godaddy.controller.ContactWrongMappingException;
import com.godaddy.entity.ContactEntity;
import com.godaddy.service.ContactDomainModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMapperTest {

    @Test
    public void checkMappingFromContactDomainModelToContactEntity() {
        String name = "mary";
        String phones = "[12,45,78]";
        String[] convertedPhones = new String[]{"12", "45", "78"};
        ContactDomainModel contactDomainModel = new ContactDomainModel(name, phones);
        List<ContactEntity> contactEntities = RepositoryMapper.toEntityContact(contactDomainModel);

        if (contactEntities.size() == 0) {
            Assert.assertTrue(false);
            //ToDo add logger;
            //something went wront
        }
        for (int i = 0; i < contactEntities.size(); i++) {
            Assert.assertEquals(contactEntities.get(i).getName(), name);
            Assert.assertEquals(contactEntities.get(i).getPhone(), convertedPhones[i]);
        }
    }


    @Test(expected = ContactWrongMappingException.class)
    public void checkIfExceptionThrowed() {
        RepositoryMapper.toContactDomainModel(new ArrayList<>());
    }
}
