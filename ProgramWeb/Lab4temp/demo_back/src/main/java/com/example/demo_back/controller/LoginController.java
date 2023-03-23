package com.example.demo_back.controller;

import com.example.demo_back.dao.AccountJpa;
import com.example.demo_back.dto.LoginResponse;
import com.example.demo_back.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    AccountService accountService;
    @PostMapping("/main")
    @ResponseBody
    public LoginResponse main(HttpServletRequest request) {
        if (request.getParameter("username") == null || request.getParameter("password") == null || request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Username or password can't be empty");
            return loginResponse;
        }
        System.out.print("username=" + request.getParameter("username") + " password=" + request.getParameter("password") + "\n");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = passwordSHA(password);
        List<AccountJpa> list = accountService.findAccountByName(username);
        if (list.size() == 1&&list.get(0).getPassword().equals(password)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(true);
            loginResponse.setMessage("Access");
            return loginResponse;
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Denied");
            return loginResponse;
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