package com.godaddy.utils;

import com.godaddy.controller.ContactModel;
import com.godaddy.controller.ContactWrongMappingException;
import com.godaddy.service.ContactDomainModel;
import org.junit.Assert;
import org.junit.Test;

public class ModelMapperTest {

    @Test
    public void checkMappingFromContactDomainModelToContactModel() {
        String name = "mary";
        String phones = "[12,45,78]";
        String[] convertedPhones = new String[]{"12", "45", "78"};
        ContactDomainModel contactDomainModel = new ContactDomainModel(name, phones);
        ContactModel contactModel = ModelMapper.toContactModel(contactDomainModel);
        Assert.assertEquals(contactModel.getName(), name);
        Assert.assertEquals(contactModel.getPhones(), convertedPhones);
    }

    @Test(expected = ContactWrongMappingException.class)
    public void checkIfExceptionThrowed() {
        ModelMapper.toContactModel(null);
    }
}
