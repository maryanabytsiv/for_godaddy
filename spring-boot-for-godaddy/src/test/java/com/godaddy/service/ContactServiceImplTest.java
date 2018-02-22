package com.godaddy.service;

import com.godaddy.repository.ContactRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ContactServiceImplTest {

    @TestConfiguration
    static class ContactServiceImplTestContextConfiguration {

        @Bean
        public ContactService contactService() {
            return new ContactServiceImpl();
        }
    }

    @Autowired
    private ContactService contactService;

    @MockBean
    private ContactRepository contactRepository;

    private final String NAME = "mary";
    private final String PHONE = "123456";

    @Test
    public void whenValidNameThenContactShouldBeFound() {

        ContactDomainModel mary = new ContactDomainModel(NAME, PHONE);

        Mockito.when(contactRepository.getByName(NAME))
                .thenReturn(mary);

        ContactDomainModel findings = contactService.getByName(NAME);

        Assert.assertNotNull(findings);
        Assert.assertEquals(findings.getName(),NAME);
        Assert.assertEquals(findings.getPhones(),PHONE);
    }

}
