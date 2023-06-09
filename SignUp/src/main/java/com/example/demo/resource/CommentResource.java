package com.example.demo.resource;

import java.util.Calendar;

import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskComments;
import com.example.demo.Entity.User;

public class CommentResource {

	private int taskCommentsID;
	private String comment;
	private Calendar commentDateAndTime;
	private Task task;
	private User user;
	
	

	

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public CommentResource(TaskComments comments ) {
//		super();
		this.taskCommentsID = comments.getTaskCommentsID();
		this.comment = comments.getComment();
		this.commentDateAndTime = comments.getCommentDateAndTime();
		this.task=comments.getTask();
		this.user = comments.getUser();
		
	}

}