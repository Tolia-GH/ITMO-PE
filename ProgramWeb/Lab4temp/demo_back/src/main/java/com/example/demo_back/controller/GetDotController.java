package com.example.demo_back.controller;

import com.example.demo_back.JPAdatabase.AccountJpa;
import com.example.demo_back.JPAdatabase.DotJpa;
import com.example.demo_back.configuration.bean.Dot;
import com.example.demo_back.response.DotResponse;
import com.example.demo_back.service.AccountService;
import com.example.demo_back.service.DotService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class GetDotController {
    @Autowired
    DotService dotService;
    @Autowired
    AccountService accountService;
    @ResponseBody
    @RequestMapping(value = "/getDot")
    public DotResponse getDot(HttpServletRequest request){
        try {
            System.out.print("Y="+request.getParameter("Y")+" X="+request.getParameter("X")+" R="+request.getParameter("R")+"\n");
            Double X = Double.parseDouble(request.getParameter("X"));
            Double Y = Double.parseDouble(request.getParameter("Y"));
            Integer R = Integer.parseInt(request.getParameter("R"));

            String Username = request.getParameter("Username");//
            //System.out.println(Username);//
            String Password = request.getParameter("Password");
            Password = passwordSHA(Password);

            List<AccountJpa> list = accountService.findAccountByName(Username);
            if (list.size() == 1 && list.get(0).getPassword().equals(Password)) {
                if(Y > 5.0||Y <- 5.0){
                    DotResponse responseDot = new DotResponse();
                    responseDot.setMessage("Please make sure your y is not bigger than 5, and not smaller than -5\n");
                    return responseDot;
                }else if(X > 4 || X < -4){
                    DotResponse responseDot = new DotResponse();
                    responseDot.setMessage("Please make sure your X is not bigger than 4, and not smaller than -4\n");
                    return responseDot;
                }

                Dot newDot = new Dot(Username, X, Y, R);
                dotService.addDot(newDot.getOwner(), newDot.getX(),newDot.getY(),newDot.getR(),newDot.getHit(),newDot.getDate());

                List<DotJpa> fetchedList = dotService.findAllByOwner(Username);
                for (DotJpa dot :
                        fetchedList) {
                    System.out.println(dot.getOwner() + ", " + dot.getX() + ", " + dot.getY() + ", " + dot.getR() + ", " + dot.getHit());
                }
                return new DotResponse(fetchedList, newDot.getOwner(), newDot.getX(),newDot.getY(),newDot.getR(),newDot.getHit(),newDot.getDate(),"success\n",false);
            }

        }catch (NumberFormatException e){
            DotResponse responseDot = new DotResponse();
            responseDot.setMessage("Please input an available number for Y\n");
            return responseDot;
        }
        DotResponse response = new DotResponse();
        response.setMessage("Not authorized!");
        return response;
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
