package com.example.userservice.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.userservice.constants.ErrorMessages;
import com.example.userservice.domain.AppUser;
import com.example.userservice.exception.DuplicateEmailException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.infrastructure.AppUserRepository;

@Service
public class AppUserService {

	private final AppUserRepository appUserRepository;

	public AppUserService(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}

	public AppUser createUser(AppUser appUser) {
		if (appUserRepository.findByEmail(appUser.getEmail()).isPresent()) {
			throw new DuplicateEmailException(ErrorMessages.EMAIL_EXISTS + appUser.getEmail());
		}
		return appUserRepository.save(appUser);
	}

	public Optional<AppUser> getUser(Long id) {
		return appUserRepository.findById(id);
	}

	public List<AppUser> getAllUsers() {
		return appUserRepository.findAll();
	}

	public AppUser updateUser(Long id, AppUser updatedUser) {

		AppUser existing = appUserRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

		// Update existing user
		existing.setName(updatedUser.getName());
		existing.setEmail(updatedUser.getEmail());

		return appUserRepository.save(existing);

	}

}
