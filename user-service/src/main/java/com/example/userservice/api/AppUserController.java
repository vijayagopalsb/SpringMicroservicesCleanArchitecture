package com.example.userservice.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.api.dto.AppUserDTO;
import com.example.userservice.application.AppUserService;
import com.example.userservice.domain.AppUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.userservice.constants.ApiPaths;

@RestController
@RequestMapping(ApiPaths.USERS)
public class AppUserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserController.class);
	private final AppUserService appUserService;

	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@PostMapping
	public ResponseEntity<AppUserDTO> createUser(@RequestBody AppUserDTO appUserDTO) {
		LOGGER.info("User creation started...");
		AppUser appUser = toEntity(appUserDTO);
		AppUser newUser = appUserService.createUser(appUser);
		LOGGER.info("User created successfully");
		return ResponseEntity.ok(toDTO(newUser));
	}

	@GetMapping(ApiPaths.USER_BY_ID)
	public ResponseEntity<AppUserDTO> getUser(@PathVariable Long id) {
		return appUserService.getUser(id).map(user -> ResponseEntity.ok(toDTO(user)))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<AppUserDTO> getAllUsers() {
		return appUserService.getAllUsers().stream().map(this::toDTO).toList();
	}
	
	@PutMapping(ApiPaths.USER_BY_ID)
	public ResponseEntity<AppUserDTO> updateUser(@PathVariable Long id, @RequestBody AppUserDTO  appUserDTO){
		AppUser userEntity = toEntity(appUserDTO);
		AppUser updated = appUserService.updateUser(id,  userEntity);
		return ResponseEntity.ok(toDTO(updated));
		
	}

	private AppUser toEntity(AppUserDTO appUserDTO) {
		AppUser appUser = new AppUser();
		appUser.setId(appUserDTO.getId());
		appUser.setName(appUserDTO.getName());
		appUser.setEmail(appUserDTO.getEmail());
		return appUser;
	}

	private AppUserDTO toDTO(AppUser appUser) {
		AppUserDTO dto = new AppUserDTO();
		dto.setId(appUser.getId());
		dto.setName(appUser.getName());
		dto.setEmail(appUser.getEmail());
		return dto;
	}

}
