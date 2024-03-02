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
        if (userRepo.findUserJpaByEmail(email).size()==0){
            return null;
        }
        return userRepo.findUserJpaByEmail(email).get(0);
    }

    public List<UserJPA> findAccountByPhone(String phone){
        return userRepo.findUserJpaByPhone(phone);
    }

    public UserJPA findAccountById(Integer id){
        if (userRepo.findUserJpaById(id).size()==0){
            return null;
        }
        return userRepo.findUserJpaById(id).get(0);
    }
}
