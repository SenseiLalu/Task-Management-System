package com.example.demo.DTOClasses;

import java.util.Calendar;

public class TaskCommentDTO {
	
	private int taskCommentsID;
	
	private String comment;
	
	private Calendar commentDateAndTime;
	
	private int taskId;
	
	private int userId;
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskCommentsID() {
		return taskCommentsID;
	}

	public void setTaskCommentsID(int taskCommentsID) {
		this.taskCommentsID = taskCommentsID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Calendar getCommentDateAndTime() {
		return commentDateAndTime;
	}

	public void setCommentDateAndTime(Calendar commentDateAndTime) {
		this.commentDateAndTime = commentDateAndTime;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
	

}
