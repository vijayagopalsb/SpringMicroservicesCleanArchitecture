package com.example.orderservice.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.application.service.dto.UserDto;

@Service
public class UserClientService {

	@Autowired
	private RestTemplate restTemplate;
	
	

	public UserDto getUserDetails(Long userId) {
		return restTemplate.getForObject("http://user-service/users/" + userId, UserDto.class);
	}

}
