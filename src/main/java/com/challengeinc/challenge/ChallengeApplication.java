package com.challengeinc.challenge;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChallengeApplication.class, args);
		System.out.println("Starter");

	}
 
}
