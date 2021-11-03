package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.poc.*"})
public class Poc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc1Application.class, args);
	}

}
