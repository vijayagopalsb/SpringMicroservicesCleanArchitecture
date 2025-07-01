package com.example.userservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);
    public static void main(String[] args) {
    	
    	LOGGER.info("Starting User Service...");
        SpringApplication.run(UserServiceApplication.class, args);
        LOGGER.info("User Service Started Successfully");
        
    }
}
