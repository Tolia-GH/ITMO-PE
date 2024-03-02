package com.demo.backend.service;

import com.demo.backend.databaseJPA.account.UserJPA;
import com.demo.backend.databaseJPA.account.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    UserRepo userRepo;

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
