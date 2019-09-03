package com.nute.contact.controllers;

import com.google.common.collect.Lists;
import com.nute.contact.entities.Contact;
import com.nute.contact.entities.EntityNotFoundException;
import com.nute.contact.entities.User;
import com.nute.contact.repositories.ContactRepository;
import com.nute.contact.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    public ContactController(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping(value = "/{id}/contacts")
    public List<Contact> getContactsForUser(@PathVariable("id") long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("UserID not found: " + userId));

        List<Contact> contacts = Lists.newArrayList(contactRepository.findAllById(user.getContactIdList()));
        LOGGER.info("Found {} contacts", contacts.size());

        return contacts;
    }
}
