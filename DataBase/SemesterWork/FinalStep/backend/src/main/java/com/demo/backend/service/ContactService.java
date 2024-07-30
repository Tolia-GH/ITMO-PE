package com.demo.backend.service;

import com.demo.backend.databaseJPA.account.UserJPA;
import com.demo.backend.databaseJPA.account.UserRepo;
import com.demo.backend.databaseJPA.contact.ContactJPA;
import com.demo.backend.databaseJPA.contact.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;
    @Autowired
    private UserRepo userRepo;

    public void addContact(Integer id, String phone, String email) {
        ContactJPA contactJPA = new ContactJPA();

        contactJPA.setUser_id(id);
        contactJPA.setPhone_num(phone);
        contactJPA.setEmail(email);

        contactRepo.save(contactJPA);
    }
}
