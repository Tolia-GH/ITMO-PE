package com.example.demo_back.controller;

import com.example.demo_back.JPAdatabase.AccountJpa;
import com.example.demo_back.JPAdatabase.DotJpa;
import com.example.demo_back.response.LoginResponse;
import com.example.demo_back.service.AccountService;
import com.example.demo_back.service.DotService;
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
    @Autowired
    DotService dotService;
    @PostMapping("/main")
    @ResponseBody
    public LoginResponse main(HttpServletRequest request) {
        if (request.getParameter("username") == null || request.getParameter("password") == null || request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Username or password can't be empty!");
            return loginResponse;
        }

        System.out.print("username=" + request.getParameter("username") + " password=" + request.getParameter("password") + "\n");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = passwordSHA(password);
        List<AccountJpa> list = accountService.findAccountByName(username);
        if (list.size() == 1 && list.get(0).getPassword().equals(password)) {
            List<DotJpa> fetchedList = dotService.findAllByOwner(username);

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(true);
            loginResponse.setMessage("Welcome, " + request.getParameter("username"));
            loginResponse.setDotList(fetchedList);
            for (DotJpa dot : loginResponse.getDotList()) {
                System.out.println(dot.getOwner() + ", " + dot.getX() + ", " + dot.getY() + ", " + dot.getR() + ", " + dot.getHit());
            }
            return loginResponse;
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Username or Password error!");
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