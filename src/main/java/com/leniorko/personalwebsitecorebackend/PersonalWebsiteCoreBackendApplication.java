package com.leniorko.personalwebsitecorebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonalWebsiteCoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalWebsiteCoreBackendApplication.class, args);
	}

	@GetMapping(value = "/")
	public static String testMessage() {
		return "Test route";
	}

}
