package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProjectID")
	private int projectId;
	@Column(name = "ProjectName")
	private String projectName;
	@Column(name = "IsActive")
	private boolean isActive;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "projects" , fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "project" , cascade = CascadeType.ALL)
    private List<Task> task = new ArrayList<>();
	

	
	
	public List<Task> getTask() {
		return task;
	}





	public void setTask(List<Task> task) {
		this.task = task;
	}





	public int getProjectId() {
		return projectId;
	}





	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}





	public String getProjectName() {
		return projectName;
	}





	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}





	public boolean isActive() {
		return isActive;
	}





	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}





	public Set<User> getUsers() {
		return users;
	}





	public void setUsers(Set<User> users) {
		this.users = users;
	}





	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", isActive=" + isActive
				+ ",]";
	}





	
	
	
	
	
	
}
