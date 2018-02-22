package com.godaddy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactWrongMappingException extends RuntimeException{
    public ContactWrongMappingException(String exception) {
        super(exception);
    }
}
