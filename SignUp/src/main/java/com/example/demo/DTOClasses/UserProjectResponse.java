package com.example.demo.DTOClasses;

public class UserProjectResponse {
	private String username;
	private String projectName;

	
	

	public UserProjectResponse(String username, String projectName) {
		super();
		this.username = username;
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	

}
