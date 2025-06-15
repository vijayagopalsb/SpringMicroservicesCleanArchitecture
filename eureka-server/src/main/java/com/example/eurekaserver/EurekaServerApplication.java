package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServerApplication.class);

	public static void main(String[] args) {

		LOGGER.info("Starting Eureka Server...");
		SpringApplication.run(EurekaServerApplication.class, args);
		LOGGER.info("Eureka Server Started Successfully.");

	}
}
