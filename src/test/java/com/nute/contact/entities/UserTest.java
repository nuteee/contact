package com.nute.contact.entities;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class UserTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(User.class).suppress(Warning.STRICT_INHERITANCE).withIgnoredFields("id").verify();
    }
}
