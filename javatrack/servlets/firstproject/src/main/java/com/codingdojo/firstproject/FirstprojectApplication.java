package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	@RequestMapping("/")
	public String hello() {
		return "Hello Client! How are you doing?";
	}
	@RequestMapping("/random")
	public String hello1() {
		return "Spring Boot is great!! So easy to respond!";
	}
}
