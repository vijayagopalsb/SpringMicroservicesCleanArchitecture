package com.example.userservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class UserServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);
    public static void main(String[] args) {
    	
    	LOGGER.info("Starting Order Service...");
        SpringApplication.run(UserServiceApplication.class, args);
        LOGGER.info("Order Service Started Successfully");
        
    }
}
