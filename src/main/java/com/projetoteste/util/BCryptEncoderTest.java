package com.projetoteste.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {
	public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "admin123";
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println(encodedPassword);
    }

}
