package com.souza.charles.triathlete_sponsorship_web;

import com.souza.charles.triathlete_sponsorship_web.environments.LoadEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriathleteSponsorshipWebApplication {

	public static void main(String[] args) {
		LoadEnvironment.loadEnv();
		SpringApplication.run(TriathleteSponsorshipWebApplication.class, args);
	}

}
