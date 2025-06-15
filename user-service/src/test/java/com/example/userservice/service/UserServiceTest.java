package com.example.userservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.userservice.application.AppUserService;
import com.example.userservice.domain.AppUser;
import com.example.userservice.infrastructure.AppUserRepository;

class UserServiceTest {
	
	@Mock
	private AppUserRepository appUserRepository;
	
	@InjectMocks
	private AppUserService appUserService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	// Test case: Create User
	@Test
	void testCreateUser_success () {
		AppUser appUser = new AppUser(null,  "Vijay", "vijay@gmail.com");
		AppUser savedUser = new AppUser(1L, "Vijay", "vijay@gmail.com");
		
		when(appUserRepository.save(any(AppUser.class))).thenReturn(savedUser);
		
		AppUser userResult = appUserService.createUser(appUser);
		
		assertNotNull(userResult.getId());
		assertEquals("Vijay", userResult.getName());
		assertEquals("vijay@gmail.com", userResult.getEmail());
		verify(appUserRepository, times(1)).save(appUser);
	}

}
