package com.sourabh.rest.webservice.restfulwebservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encoderstring = encoder.encode("pavitra");
		System.out.println("EncoderString = " + encoderstring);
	}
	
	
}
