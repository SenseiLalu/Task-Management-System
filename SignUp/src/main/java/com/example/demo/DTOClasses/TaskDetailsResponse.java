package com.example.demo.DTOClasses;

import java.time.LocalDate;
import java.util.Calendar;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.TaskCategory;
import com.example.demo.Entity.User;

public class TaskDetailsResponse {

	private int taskId;

	private String taskName;

	private String longDescription;
	
	private LocalDate assigenedDate;
	
	private LocalDate deuDate;

	private Status statusId;
	
	private User assignedDto;
	
	private User createdBy;
	
	private Project projectName;

	private TaskCategory taskCategoryDescription;
	
	
    private Calendar createdOn;
    
    

	public Project getProjectName() {
		return projectName;
	}

	public void setProjectName(Project projectName) {
		this.projectName = projectName;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public LocalDate getAssigenedDate() {
		return assigenedDate;
	}

	public void setAssigenedDate(LocalDate assigenedDate) {
		this.assigenedDate = assigenedDate;
	}

	public LocalDate getDeuDate() {
		return deuDate;
	}

	public void setDeuDate(LocalDate deuDate) {
		this.deuDate = deuDate;
	}

	

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	public TaskCategory getTaskCategoryDescription() {
		return taskCategoryDescription;
	}

	public void setTaskCategoryDescription(TaskCategory taskCategoryDescription) {
		this.taskCategoryDescription = taskCategoryDescription;
	}

	public User getAssignedDto() {
		return assignedDto;
	}

	public void setAssignedDto(User assignedDto) {
		this.assignedDto = assignedDto;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	
    
}
