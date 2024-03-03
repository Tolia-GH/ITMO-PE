package com.demo.backend.controller;

import com.demo.backend.response.AccountResponse;
import com.demo.backend.security.PasswordSecurity;
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

    public void printRequestData(HttpServletRequest request) {
        System.out.println(request.getParameter("firstName"));
        System.out.println(request.getParameter("lastName"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("gender"));
        System.out.println(request.getParameter("age"));
    }

    public boolean validateData(String firstName, String lastName, String password, String phone, String email, String gender, Integer age) {
        return true;
    }

    @PostMapping("/signUp")
    @ResponseBody
    public AccountResponse signUp(HttpServletRequest request) {
        AccountResponse accountResponse = new AccountResponse();

        printRequestData(request);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Integer age = Integer.parseInt(request.getParameter("age"));

        if(validateData(firstName, lastName, password, phone, email, gender, age)) {
            password = PasswordSecurity.passwordSHA(password);
            if (accountService.findAccountByEmail(email) != null ||
            accountService.findAccountByPhone(phone) != null) {
                accountResponse.setSuccess(false);
                accountResponse.setMessage("This phone number or email is already be used");
            } else {
                //Integer id = accountService.findLatestUserId();
                accountService.addAccount(firstName, lastName, password, gender, age);
                Integer id = accountService.findLatestUserId();
                contactService.addContact(id, phone, email);
                accountResponse.setSuccess(true);
                accountResponse.setMessage("Success");
            }
        }

        return accountResponse;
    }
}
