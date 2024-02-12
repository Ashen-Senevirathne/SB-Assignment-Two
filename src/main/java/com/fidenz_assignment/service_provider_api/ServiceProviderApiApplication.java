package com.fidenz_assignment.service_provider_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ServiceProviderApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderApiApplication.class, args);
	}
}
