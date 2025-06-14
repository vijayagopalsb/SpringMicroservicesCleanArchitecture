// api/dto/AppUserDTO.java

package com.example.userservice.api.dto;

public class AppUserDTO {

	private Long id;
	private String name;
	private String email;

	// No-arg constructor
	public AppUserDTO() {
	}
	
	// Except Id argument
	public AppUserDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	// All-args constructor (optional)
	public AppUserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AppUserDTO [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
