package com.notifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthdaywishApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdaywishApplication.class, args);
	}

}
