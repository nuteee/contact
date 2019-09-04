package com.nute.contact.controllers;

import com.google.common.collect.Lists;
import com.nute.contact.entities.Contact;
import com.nute.contact.entities.EntityNotFoundException;
import com.nute.contact.entities.User;
import com.nute.contact.repositories.ContactRepository;
import com.nute.contact.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long userId) throws EntityNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("UserID not found: " + userId));
    }

    @GetMapping("/user/{id}/contacts")
    public List<Contact> getContactsForUser(@PathVariable("id") long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("UserID not found: " + userId));

        List<Contact> contacts = Lists.newArrayList(contactRepository.findAllById(user.getContactIdList()));
        LOGGER.info("Found {} contacts", contacts.size());

        return contacts;
    }

    @PutMapping("/user/{id}/contacts/add")
    public User addContactToUser(@PathVariable("id") long userId, @RequestBody Contact contact) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("UserID not found: " + userId));

        user.addContact(contact);

        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}/contacts/delete")
    public void deleteContactForUser(@PathVariable("id") long userId, @RequestBody Contact contact) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("UserID not found: " + userId));

        user.removeContact(contact);

        contactRepository.deleteById(contact.getId());
    }

    @PostMapping("/contacts/{id}/edit")
    public Contact editContactOfUser(@PathVariable("id") long userId, @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }


}
