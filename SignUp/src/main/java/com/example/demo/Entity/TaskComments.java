package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TaskComments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskCommentsID")
	private int taskCommentsID;
	
	@Column(name = "Comment")
	private String comment;
	
	@Column(name = "CommentDate&Time")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Calendar commentDateAndTime;
	
	
//	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "task_id")
    private Task task;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "user_id")
    private User user;
	
	
//	
//	@ManyToOne(cascade = CascadeType.ALL)
////	@JsonIgnore
//    @JoinColumn(name = "project_Id", referencedColumnName = "projectId")
//    private Task task2;
	
//	@ManyToMany(mappedBy = "comments")
//    private List<Task> tasks;
	
//	 @ManyToMany(mappedBy = "comments")
//	    private Set<User> users = new HashSet<>();
//	    @ManyToMany(mappedBy = "comments")
//	    private Set<Task> tasks = new HashSet<>();
	
	
//	    @ManyToMany(mappedBy = "comment")
//	    private Set<CommentUserTask> commentUserTasks = new HashSet<>();
	    
	    
//	@JsonIgnore
//	 @ManyToMany(cascade = CascadeType.ALL)
//	    @JoinTable(name = "task_comment",
//	            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "taskCommentsID"),
//	            inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "Task_ID"))
//	    private Set<Task> tasks = new HashSet<>();
//	    
	   
	   
	    
//	@ManyToOne
//	@JoinColumn(name="task_id")
//	private Task task;
	
	
//	@OneToOne(mappedBy = "taskComments")
//	private Task task;
//
//	public int getTaskCommentsID() {
//		return taskCommentsID;
//	}

//	public Task getTask() {
//		return task;
//	}
//
//	public void setTask(Task task) {
//		this.task = task;
//	}


//	public Set<CommentUserTask> getCommentUserTasks() {
//			return commentUserTasks;
//		}
//
//		public void setCommentUserTasks(Set<CommentUserTask> commentUserTasks) {
//			this.commentUserTasks = commentUserTasks;
//		}

//	public Set<User> getUsers() {
//			return users;
//		}
//
//		public void setUsers(Set<User> users) {
//			this.users = users;
//		}
//
//		public Set<Task> getTasks() {
//			return tasks;
//		}
//
//		public void setTasks(Set<Task> tasks) {
//			this.tasks = tasks;
//		}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public void setTaskCommentsID(int taskCommentsID) {
		this.taskCommentsID = taskCommentsID;
	}

//	public Set<Task> getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(Set<Task> tasks) {
//		this.tasks = tasks;
//	}



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

	public int getTaskCommentsID() {
		return taskCommentsID;
	}

	@Override
	public String toString() {
		return "TaskComments [taskCommentsID=" + taskCommentsID + ", comment=" + comment + ", commentDateAndTime="
				+ commentDateAndTime + ", ]";
	}

	public Optional<CommentUserTask> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
}
