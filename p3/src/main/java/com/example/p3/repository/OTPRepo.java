package com.example.p3.repository;

import com.example.p3.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepo extends JpaRepository<OTP,Integer> {

    @Query(value = "SELECT * FROM otp WHERE otp_code=:otp",nativeQuery = true)
    OTP findByOtpCode(String otp);
}
