package com.godaddy.controller;

import com.godaddy.service.ContactService;
import com.godaddy.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello there!");
        return "index";
    }

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("userForm", new ContactModel());
        return "user/form";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String userAdd(@RequestBody ContactModel contact, Model model, BindingResult result) {
        String message = contactService.addContact(ModelMapper.toContactDomainModel(contact));
        model.addAttribute("infoMsg", message);
        return "user/info";
    }

    @GetMapping("/byId/{id}")
    public String userById(@PathVariable String id, Model model) {
        try {
            model.addAttribute("userForm", ModelMapper.toContactModel(contactService.getByID(id)));
        } catch (ContactWrongMappingException ex) {
            model.addAttribute("infoMsg", "Contact not found with id: " + id + ". Reason: " + ex.getMessage());
            return "user/info";
        }
        return "user/form";
    }

    @GetMapping("/byName/{name}")
    public String userByName(@PathVariable String name, Model model) {
        ContactModel contactModel;
        try {
            contactModel = ModelMapper.toContactModel(contactService.getByName(name));
        } catch (ContactWrongMappingException ex) {
            model.addAttribute("infoMsg", "Contact not found with name: " + name + ". Reason: " + ex.getMessage());
            return "user/info";
        }

        model.addAttribute("userForm", contactModel);

        return "user/viewForm";
    }

    @GetMapping("/close")
    public String close(Map<String, Object> model) {
        model.put("message", "Closed");
        return "index";
    }
}
