package com.godaddy.service;

public class ContactDomainModel {
    String name;

    String phones;

    public ContactDomainModel() {
    }

    public ContactDomainModel(String name, String phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
}
