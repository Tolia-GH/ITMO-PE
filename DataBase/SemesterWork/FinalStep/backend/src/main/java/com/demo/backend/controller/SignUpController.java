package com.demo.backend.controller;

import com.demo.backend.response.AccountResponse;
import com.demo.backend.service.AccountService;
import com.demo.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {
    @Autowired
    AccountService accountService;
    @Autowired
    ContactService contactService;

    @PostMapping("/signUp")
    @ResponseBody
    public AccountResponse main(HttpServletRequest request) {
        return new AccountResponse();
    }
}
