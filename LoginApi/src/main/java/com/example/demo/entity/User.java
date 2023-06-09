package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private int userId;
	private String username;
	private String password;
	private boolean isActive;
	private String role;
	private String email;

	public User() {
		super();
	}

	public User(int userId, String username, String password, boolean isActive, String role, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.role = role;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", isActive=" + isActive
				+ ", role=" + role + ", email=" + email + "]";
	}

}