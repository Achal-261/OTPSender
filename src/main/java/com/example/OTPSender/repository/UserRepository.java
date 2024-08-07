package com.example.OTPSender.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OTPSender.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
