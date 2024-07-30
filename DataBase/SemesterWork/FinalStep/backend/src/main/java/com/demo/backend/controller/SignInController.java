package com.demo.backend.controller;

import com.demo.backend.databaseJPA.account.UserJPA;
import com.demo.backend.response.AccountResponse;
import com.demo.backend.security.PasswordSecurity;
import com.demo.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Controller
public class SignInController {
    @Autowired
    AccountService accountService;
    @PostMapping("/signIn")
    @ResponseBody
    public AccountResponse signIn(HttpServletRequest request) {
        AccountResponse accountResponse = new AccountResponse();
        if (request.getParameter("username") == null ||
                request.getParameter("password") == null ||
                request.getParameter("username").isEmpty() ||
                request.getParameter("password").isEmpty()) {
            accountResponse.setSuccess(false);
            accountResponse.setMessage("Username or password can't be empty!");
            return accountResponse;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username=" + username + ", password=" + password);
        password = PasswordSecurity.passwordSHA(password);
        System.out.println("passwordSHA=" + password);

        String regexPhone = "\\+[1-9]+[0-9]*";
        String regexEmail = ".*@.+\\.com";

        UserJPA userJPA;

        if (Pattern.matches(regexPhone, username)) {
            userJPA = accountService.findAccountByPhone(username);
            if (userJPA.getPassword().equals(password)) {
                accountResponse.setSuccess(true);
                accountResponse.setMessage("Success");
            } else {
                accountResponse.setSuccess(false);
                accountResponse.setMessage("Phone number or password wrong!");
            }
        } else if (Pattern.matches(regexEmail, username)) {
            userJPA = accountService.findAccountByEmail(username);
            if (userJPA.getPassword().equals(password)) {
                accountResponse.setSuccess(true);
                accountResponse.setMessage("Success");
            } else {
                accountResponse.setSuccess(false);
                accountResponse.setMessage("Email or password wrong!");
            }
            accountResponse.setSuccess(true);
            accountResponse.setMessage("Login by Email");
        }
        return accountResponse;
    }
}
