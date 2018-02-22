package com.godaddy.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactModel {
    String name;

    @JsonProperty("phones")
    String[] phones;

    public ContactModel() {
    }

    public ContactModel(String name, String[] phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

}
