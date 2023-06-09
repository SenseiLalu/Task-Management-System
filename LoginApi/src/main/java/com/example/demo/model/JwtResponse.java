package com.example.demo.model;

import com.example.demo.entity.User;

public class JwtResponse {

	String token;
	int userId;

	public JwtResponse() {
		super();
	}

	public JwtResponse(String token,User user) {
		this.token = token;
		this.userId=user.getUserId();
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}

}
