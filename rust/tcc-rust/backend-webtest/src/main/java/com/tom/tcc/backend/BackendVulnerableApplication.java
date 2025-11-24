package com.tom.tcc.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendVulnerableApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BackendVulnerableApplication.class);
		// app.setBanner();
		app.run(args);
	}

}
