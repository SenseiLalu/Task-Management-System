package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TaskCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskCategoryID")
	private int taskCategoryId;

	@Column(name = "TaskCategoryDescription")
	private String taskCategoryDescription;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Task> task = new ArrayList<>();

	
	
	

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public int getTaskCategoryId() {
		return taskCategoryId;
	}

	public void setTaskCategoryId(int taskCategoryId) {
		this.taskCategoryId = taskCategoryId;
	}

	public String getTaskCategoryDescription() {
		return taskCategoryDescription;
	}

	public void setTaskCategoryDescription(String taskCategoryDescription) {
		this.taskCategoryDescription = taskCategoryDescription;
	}

	@Override
	public String toString() {
		return "TaskCategory [taskCategoryId=" + taskCategoryId + ", taskCategoryDescription=" + taskCategoryDescription
				+ ", task=" + task + "]";
	}

	
	

	

}
