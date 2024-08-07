package com.example.OTPSender.service;


import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public String generateOtp(String Username) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int otp=100000+random.nextInt(999999); //1lac to 9lac 9999 paryanttcha no.
		String value=String.valueOf(otp);
		return value;
	}

}