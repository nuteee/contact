package com.nute.contact.entities;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ContactCollection")
public class Contact {

    @Id
    private long id;

    @Field("Name")
    private final String name;

    @Field("PhoneNubmer")
    private final String phoneNumber;

    @Field("Email")
    private final String email;

    public Contact(String name, String phoneNumber, String email) throws InterruptedException {
        this.name = Validate.notEmpty(name);
        this.phoneNumber = Validate.notEmpty(phoneNumber);
        this.email = validateEmail(email);
    }

    private String validateEmail(String email) throws InterruptedException {
        if (EmailValidator.getInstance().isValid(email)) {
            return email;
        } else {
            throw new InterruptedException("Invalid email: " + email);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Contact other = (Contact) o;

        return new EqualsBuilder()
                .append(name, other.name)
                .append(phoneNumber, other.phoneNumber)
                .append(email, other.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(phoneNumber).append(email).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("phoneNumber", phoneNumber)
                .append("email", email)
                .toString();
    }
}