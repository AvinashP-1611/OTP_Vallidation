package com.example.p3.controller;

import com.example.p3.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @Autowired
    OTPService otpService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String about(){
//        otpService.
//        th:text="${}
        return "index";
    }
}
