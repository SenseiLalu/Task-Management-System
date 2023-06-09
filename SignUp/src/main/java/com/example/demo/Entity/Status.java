package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Status {

	@Id
	@Column(name = "Status_ID")
	private int statusId;
	
	

	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	@Column(name = "Description")
	
	private String description;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "status" , cascade = CascadeType.ALL)
    private List<Task> task = new ArrayList<>();
	
	
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", description=" + description + ", task=" + task + "]";
	}
	
	
	
	

	
	
	
	
	
}
