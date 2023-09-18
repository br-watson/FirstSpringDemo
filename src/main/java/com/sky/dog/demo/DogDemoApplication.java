package com.sky.dog.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DogDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogDemoApplication.class, args);
	}

}
