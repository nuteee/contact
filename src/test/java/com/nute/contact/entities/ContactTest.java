package com.nute.contact.entities;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class ContactTest {

    @Test(expected = NullPointerException.class)
    public void testForNullName() {
        new Contact(null, "12345", "test@gmail.com");
    }

    @Test(expected = NullPointerException.class)
    public void testForNullPhoneNumber() {
        new Contact("X", null, "test@gmail.com");
    }

    @Test(expected = RuntimeException.class)
    public void testForNullEmail() {
        new Contact("X", "12345", null);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Contact.class).suppress(Warning.STRICT_INHERITANCE).withIgnoredFields("id").verify();
    }
}
