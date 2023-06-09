package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Task_ID")
	private int taskId;
	@Column(name = "Task_Name")
	private String taskName;
	@Column(name = "Long_Description")
	private String longDescription;
	@Column(name = "Assigened_Date")
	private LocalDate assigenedDate;
	@Column(name = "Deu_Date")
	private LocalDate deuDate;
	
	//for the system generated date
	@Column(name = "Created_On")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Calendar createdOn;
	
	
//@ManyToMany(cascade = CascadeType.ALL,mappedBy = "taskDetails",fetch = FetchType.LAZY)
//  @JsonIgnore
//	private Set<User> user = new HashSet<>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
    @JoinColumn(name = "category_desc", referencedColumnName = "taskcategoryid")
    private TaskCategory category;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
    @JoinColumn(name = "status_desc", referencedColumnName = "status_id")
    private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
    @JoinColumn(name = "assigned_to", referencedColumnName = "userId")
    private User assignedDto;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
    @JoinColumn(name = "created_by", referencedColumnName = "userId")
    private User createdby;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
    @JoinColumn(name = "project_Id", referencedColumnName = "projectId")
    private Project project;

	
//	 @ManyToMany(mappedBy = "tasks")
//	    private List<User> users;
//
//	    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	    @JoinTable(name = "task_comment",
//	            joinColumns = @JoinColumn(name = "task_id"),
//	            inverseJoinColumns = @JoinColumn(name = "comment_id"))
//	    private List<TaskComments> comments;
//	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "task",fetch = FetchType.LAZY)
    @JsonIgnore
	private List<TaskComments> comment = new ArrayList<>();
	
	
	
	
	    
//	@ManyToMany
//    @JoinTable(name = "task_comment",
//            joinColumns = @JoinColumn(name = "task_id"),
//            inverseJoinColumns = @JoinColumn(name = "comment_id"))
//    private Set<TaskComments> comments = new HashSet<>();
	    
	
	
//	@ManyToMany(mappedBy = "task")
//	  private Set<CommentUserTask> commentUserTasks = new HashSet<>();
//	@JsonIgnore
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "task_comment", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "Task_ID"), inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "taskCommentsID"))
//	private Set<TaskComments> comments = new HashSet<>();
//
//@JsonIgnore
//	@ManyToMany(mappedBy = "tasks")
//	private Set<User> users = new HashSet<>();
	    
	

//	public Set<TaskComments> getComments() {
//		return comments;
//	}
//
//	public void setComments(Set<TaskComments> comments) {
//		this.comments = comments;
//	}
	
//	
//	public List<User> getUsers() {
//			return users;
//		}
//
//		public void setUsers(List<User> users) {
//			this.users = users;
//		}
//
//		public List<TaskComments> getComments() {
//			return comments;
//		}
//
//		public void setComments(List<TaskComments> comments) {
//			this.comments = comments;
//		}

//	public Set<CommentUserTask> getCommentUserTasks() {
//		return commentUserTasks;
//	}
//
//	public void setCommentUserTasks(Set<CommentUserTask> commentUserTasks) {
//		this.commentUserTasks = commentUserTasks;
//	}

//	public Set<TaskComments> getComments() {
//		return comments;
//	}
//
//	public void setComments(Set<TaskComments> comments) {
//		this.comments = comments;
//	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

	

	public Project getProject() {
		return project;
	}

	public List<TaskComments> getComment() {
		return comment;
	}

	public void setComment(List<TaskComments> comment) {
		this.comment = comment;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public TaskCategory getCategory() {
		return category;
	}

	public void setCategory(TaskCategory category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public User getAssignedDto() {
		return assignedDto;
	}

	public void setAssignedDto(User assignedDto) {
		this.assignedDto = assignedDto;
	}

	public User getCreatedby() {
		return createdby;
	}

	public void setCreatedby(User createdby) {
		this.createdby = createdby;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", longDescription=" + longDescription
				+ ", assigenedDate=" + assigenedDate + ", deuDate=" + deuDate + ", createdOn=" + createdOn
				+ ", category=" + category + ", status=" + status + ", assignedDto=" + assignedDto + ", createdby="
				+ createdby + "]";
	}



	
	
	

	
	
	

	

	
	

}
