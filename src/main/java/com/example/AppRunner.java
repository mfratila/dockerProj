package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AppRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);


	}

}
