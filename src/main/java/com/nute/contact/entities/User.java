package com.nute.contact.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "UserCollection")
public class User {

    @Id
    private long id;

    @Field("Name")
    private final String name;

    @Field("ContactIdList")
    private final List<Long> contactIdList;

    public User(String name, List<Long> contactIdList) {
        this.name = name;
        this.contactIdList = contactIdList;
    }

    public String getName() {
        return name;
    }

    public List<Long> getContactIdList() {
        return contactIdList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(name, user.name)
                .append(contactIdList, user.contactIdList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(contactIdList)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("contactIdList", contactIdList)
                .toString();
    }
}
