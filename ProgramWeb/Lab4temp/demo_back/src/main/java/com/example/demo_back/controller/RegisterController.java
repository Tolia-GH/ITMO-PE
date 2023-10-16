package com.example.demo_back.controller;

import com.example.demo_back.JPAdatabase.AccountJpa;
import com.example.demo_back.response.ResultSignUp;
import com.example.demo_back.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    AccountService accountService;
    @PostMapping("/register")
    public ResultSignUp register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<AccountJpa> list = accountService.findAccountByName(username);
        if(list.size() > 0){
            ResultSignUp resultSignUp = new ResultSignUp();
            resultSignUp.setSuccess(false);
            resultSignUp.setMessage("Username existed");
            return resultSignUp;
        }else {
            password = passwordSHA(password);
            accountService.addAccount(username,password);
            ResultSignUp resultSignUp = new ResultSignUp();
            resultSignUp.setSuccess(true);
            resultSignUp.setMessage("Account create successfully");
            return resultSignUp;
        }
    }

    private String passwordSHA(String password){
        byte [] bytes = password.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(bytes);
            return new BigInteger(messageDigest.digest()).toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
}
