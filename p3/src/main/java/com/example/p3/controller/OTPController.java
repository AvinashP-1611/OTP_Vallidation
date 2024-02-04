package com.example.p3.controller;

import com.example.p3.entity.OTP;
import com.example.p3.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class OTPController {
    @Autowired
    OTPService otpService;

    @PostMapping("/sendOtp")
    public ResponseEntity sendOtp(@RequestParam String phone){
        otpService.sendOtp(phone);
        return new ResponseEntity("OTP send successfully", HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity validate(@RequestParam String otpCode){
        OTP otp=otpService.validate(otpCode);
        if(otp==null) return new ResponseEntity("OTP is not valid",HttpStatus.NOT_FOUND);
        return new ResponseEntity("OTP Verified",HttpStatus.OK);
    }
}

