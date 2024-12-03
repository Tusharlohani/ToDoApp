package com.TaskManagement.ToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.TaskManagement.ToDoApp.repository")  // Adjust this package if necessary
public class ToDoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}
}
