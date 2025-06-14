package com.example.userservice.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.userservice.domain.AppUser;
import com.example.userservice.infrastructure.AppUserRepository;

@Service
public class AppUserService {

	private final AppUserRepository appUserRepository;

	public AppUserService(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}

	public AppUser createUser(AppUser appUser) {
		return appUserRepository.save(appUser);
	}

	public Optional<AppUser> getUser(Long id) {
		return appUserRepository.findById(id);
	}

	public List<AppUser> getAllUsers() {
		return appUserRepository.findAll();
	}

}
