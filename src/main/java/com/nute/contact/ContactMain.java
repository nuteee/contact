package com.nute.contact;

import com.nute.contact.config.ContactConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.nute.contact")
public class ContactMain {

    public static void main(String[] args) {
        SpringApplication.run(ContactConfig.class, args);
    }
}
