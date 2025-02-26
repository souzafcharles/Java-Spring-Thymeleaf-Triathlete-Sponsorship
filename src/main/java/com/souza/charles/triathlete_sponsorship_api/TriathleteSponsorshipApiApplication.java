package com.souza.charles.triathlete_sponsorship_api;

import com.souza.charles.triathlete_sponsorship_api.environments.LoadEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriathleteSponsorshipApiApplication {

	public static void main(String[] args) {
		LoadEnvironment.loadEnv();
		SpringApplication.run(TriathleteSponsorshipApiApplication.class, args);
	}

}
