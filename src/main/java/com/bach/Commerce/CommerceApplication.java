package com.bach.Commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.bach.Commerce")
public class CommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
		
		BCryptPasswordEncoder endcoder = new BCryptPasswordEncoder();
		String rawPassword = "123456";
		String endcodedPassword = endcoder.encode(rawPassword);
		
		System.out.println(endcodedPassword);
		
	}
}
