package com.example.userservice.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userservice.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	// Add custom queries if needed
	
	Optional<AppUser> findByEmail(String email);

}
