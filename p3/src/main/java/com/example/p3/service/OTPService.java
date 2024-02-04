package com.example.p3.service;

import com.example.p3.entity.OTP;
import com.example.p3.repository.OTPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.example.p3.Validation.*;

@Service
public class OTPService {
    @Autowired
    OTPRepo otpRepo;

    //function to send otp
    public void sendOtp(String phone) {
        if(!isValidPhoneNumber(phone)) throw new RuntimeException("please enter valid phone number");
        String generateOTP=generateOTP();
        OTP otp=new OTP();
        otp.setOtpCode(generateOTP);
        otp.setUserPhone(phone);
        otpRepo.save(otp);
    }

    //function to generate otp
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    //function to validate
    public OTP validate(String otpCode) {
        OTP otp=otpRepo.findByOtpCode(otpCode);
        System.out.println(otp+" otp");
        if(otp==null) return null;
        return otp;
    }
}
