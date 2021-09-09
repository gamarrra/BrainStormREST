package com.brainstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class brainstormApplication {

	public static void main(String[] args) {
		SpringApplication.run(brainstormApplication.class, args);
	}
}
