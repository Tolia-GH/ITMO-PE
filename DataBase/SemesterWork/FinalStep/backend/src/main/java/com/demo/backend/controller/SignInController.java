package com.demo.backend.controller;

import com.demo.backend.response.SignInResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {
    @PostMapping("/login")
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

        System.out.print("username=" + request.getParameter("username") + " password=" + request.getParameter("password") + "\n");
        return signInResponse;
    }
}
