package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CommentUserTaskId implements Serializable {
	
private int userId;
	
	private int taskId;
	
	private int taskCommentsID;
	


	public CommentUserTaskId(int userId, int taskId, int taskCommentsID) {
		super();
		this.userId = userId;
		this.taskId = taskId;
		this.taskCommentsID = taskCommentsID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	
	
	 public int getTaskCommentsID() {
		return taskCommentsID;
	}

	public void setTaskCommentsID(int taskCommentsID) {
		this.taskCommentsID = taskCommentsID;
	}

	@Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof CommentUserTaskId)) return false;
	    CommentUserTaskId that = (CommentUserTaskId) o;
	    return Objects.equals(getTaskCommentsID(), that.getTaskCommentsID()) &&
	           Objects.equals(getUserId(), that.getUserId()) &&
	           Objects.equals(getTaskId(), that.getTaskId());
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(getTaskCommentsID(), getUserId(), getTaskId());
	  }
	

}
