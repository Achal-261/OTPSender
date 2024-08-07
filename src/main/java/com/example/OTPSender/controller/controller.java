package com.example.OTPSender.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.OTPSender.service.OtpService;
import com.example.OTPSender.service.UserService;
@Controller
public class controller {
	String otp;
	@Autowired
	private UserService userservice;
	@Autowired
	private OtpService otpservice;
	
	@GetMapping("/adminlogin")
	public String getlogin(Model model) {
		return "adminlogin";
	}
	@GetMapping("/loginsts")
	public String getOtp(@RequestParam("username") String Username,Model model) {
		String mobileNo= "+91"+Username;
		String otp=userservice.generateOtp(Username);
		otpservice.sendOtp(mobileNo, otp);
		model.addAttribute(otp);
		System.out.println(otp);
		return "success";
	}
	@GetMapping("/verifyotp")	
    public String verifyOtp(@RequestParam("otp") String enteredOtp, Model model) {
        if (enteredOtp.equals(otp))
        {
            model.addAttribute("message", "OTP verified successfully!");
            return "verifyOtp";
        } 
        else
        {
            model.addAttribute("message", "Invalid OTP, please try again.");
            return "success";
        }
	
	
}
}

