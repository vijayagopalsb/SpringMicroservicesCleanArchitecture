package com.example.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.orderservice.application.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableEurekaClient
@SpringBootApplication
public class OrderServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("Starting Order Service...");
		SpringApplication.run(OrderServiceApplication.class, args);
		LOGGER.info("Order Service Started Successfully.");
		
		

	}
	@Bean
	CommandLineRunner runner(OrderService orderService) {
	    return args -> {
	        System.out.println("✅ OrderService loaded: " + orderService);
	    };
	}
}
