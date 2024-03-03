package com.demo.backend.service;

import com.demo.backend.databaseJPA.Enum.Gender;
import com.demo.backend.databaseJPA.account.UserJPA;
import com.demo.backend.databaseJPA.account.UserRepo;
import com.demo.backend.databaseJPA.contact.ContactJPA;
import com.demo.backend.databaseJPA.contact.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private ContactRepo contactRepo;

    public void addAccount(String firstName, String lastName, String password, String gender, Integer age) {
        UserJPA userJPA = new UserJPA();
        // userJPA.setId(id);
        userJPA.setUsername(firstName + " " + lastName);
        userJPA.setPassword(password);
        userJPA.setGender(Gender.valueOf(gender.toUpperCase()));
        userJPA.setAge(age);
        userRepo.save(userJPA);
    }
    public Integer findLatestUserId() {
        if (userRepo.findLatestUserId().isEmpty()) {
            return 1;
        }
        return userRepo.findLatestUserId().get(0);
    }

    public UserJPA findAccountByEmail(String email){
        if (userRepo.findUserJpaByEmail(email).isEmpty()){
            return null;
        }
        return userRepo.findUserJpaByEmail(email).get(0);
    }

    public UserJPA findAccountByPhone(String phone){
        if (userRepo.findUserJpaByPhone(phone).isEmpty()) {
            return null;
        }
        return userRepo.findUserJpaByPhone(phone).get(0);
    }

    public UserJPA findAccountById(Integer id){
        if (userRepo.findUserJpaById(id).isEmpty()){
            return null;
        }
        return userRepo.findUserJpaById(id).get(0);
    }
}
