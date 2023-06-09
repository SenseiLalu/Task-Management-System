package com.example.demo.DTOClasses;

import java.time.LocalDate;
import java.util.Calendar;

public class TaskDetailsDTO {
	
	
	private int taskId;

	private String taskName;

	private String longDescription;
	
	private LocalDate assigenedDate;
	
	private LocalDate deuDate;

	private int statusId;
	
	private int assignedDto;
	
	private int createdby;
	
	private int taskCategoryId;
	
	private int taskCommentsID;
	
	private int projectId;
	
    private Calendar createdOn;
	
	
//	public TaskDetailsDTO(String description, String username) {
//
//		this.longDescription =longDescription;
//		this.assignedDto= username;
//	}

    
    
	public Calendar getCreatedOn() {
		return createdOn;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	

	public int getAssignedDto() {
		return assignedDto;
	}

	public void setAssignedDto(int assignedDto) {
		this.assignedDto = assignedDto;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getTaskCategoryId() {
		return taskCategoryId;
	}

	public void setTaskCategoryId(int taskCategoryId) {
		this.taskCategoryId = taskCategoryId;
	}

	public int getTaskCommentsID() {
		return taskCommentsID;
	}

	public void setTaskCommentsID(int taskCommentsID) {
		this.taskCommentsID = taskCommentsID;
	}
	
	
	
	
}
