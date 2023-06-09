package com.example.demo.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class CommentUserTask {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	 
//	    @ManyToOne
//	    @JoinColumn(name = "user_id")
//	    private User user;
//
//	    @ManyToOne
//	    @JoinColumn(name = "task_id")
//	    private Task task;
//
//	    @ManyToOne
//	    @JoinColumn(name = "comment_id")
//	    private TaskComments comment;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

//		public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}
//
//		public Task getTask() {
//			return task;
//		}
//
//		public void setTask(Task task) {
//			this.task = task;
//		}
//
//		public TaskComments getComment() {
//			return comment;
//		}
//
//		public void setComment(TaskComments comment) {
//			this.comment = comment;
//		}
	    
	    
	
}
