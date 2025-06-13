package com.example.userservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrderServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceApplication.class);
    public static void main(String[] args) {
    	
    	LOGGER.info("Starting Order Service...");
        SpringApplication.run(OrderServiceApplication.class, args);
        LOGGER.info("Order Service Started Successfully");
        
    }
}
