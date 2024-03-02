package com.demo.backend.controller;

import com.demo.backend.databaseJPA.account.UserJPA;
import com.demo.backend.response.SignInResponse;
import com.demo.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class SignInController {
    @Autowired
    AccountService accountService;
    @PostMapping("/signIn")
    @ResponseBody
    public SignInResponse main(HttpServletRequest request) {
        SignInResponse signInResponse = new SignInResponse();
        if (request.getParameter("username") == null ||
                request.getParameter("password") == null ||
                request.getParameter("username").equals("") ||
                request.getParameter("password").equals("")) {
            signInResponse.setSuccess(false);
            signInResponse.setMessage("Username or password can't be empty!");
            return signInResponse;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username=" + username + ", password=" + password);
        // password = passwordSHA(password);
        System.out.println("passwordSHA=" + password);

        String regexPhone = "\\+[1-9]+[0-9]*";
        String regexEmail = ".*@.+\\.com";

        if (Pattern.matches(regexPhone, username)) {
            List<UserJPA> list = accountService.findAccountByPhone(username);
            if (list.size() == 1 && list.get(0).getPassword().equals(password)) {
                signInResponse.setSuccess(true);
                signInResponse.setMessage("Success");
            } else {
                signInResponse.setSuccess(false);
                signInResponse.setMessage("Phone number or password wrong!");
            }
        } else if (Pattern.matches(regexEmail, username)) {
            signInResponse.setSuccess(true);
            signInResponse.setMessage("Login by Email");
        }
        return signInResponse;
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
