package com.example.userservice.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.application.AppUserService;
import com.example.userservice.domain.AppUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserController.class);
	private final AppUserService appUserService;

	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@PostMapping
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
		
		LOGGER.info("Received AppUser: {}", appUser);
		AppUser newUser = appUserService.createUser(appUser);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("{id}")
	public ResponseEntity<AppUser> getUser(@PathVariable Long id) {
		return appUserService.getUser(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<AppUser> getAllUsers() {
		return appUserService.getAllUsers();
	}

}
