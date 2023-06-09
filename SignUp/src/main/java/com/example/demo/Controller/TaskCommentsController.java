package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOClasses.TaskCommentDTO;
import com.example.demo.DTOClasses.TaskDetailsDTO;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskComments;
import com.example.demo.Service.TaskCommentsService;
import com.example.demo.resource.CommentListResource;
import com.example.demo.resource.CommentResource;

import jakarta.transaction.Transactional;
@CrossOrigin
@RestController
public class TaskCommentsController {

	@Autowired
	TaskCommentsService commentsService;

//	@PostMapping("/addComments")
//	public TaskComments addcomments(@RequestBody TaskComments comments) {
//
//		TaskComments taskComments = commentsService.addCommentsToDB(comments);
//
//		return taskComments;
//	}
	
	
	@Transactional
	@PostMapping("/addComments")
	public TaskComments addTask(@RequestBody TaskCommentDTO taskCommentDto) {
		
		   TaskComments addCommentsToDB = commentsService.addCommentsToDB(taskCommentDto);
		
		return addCommentsToDB;
	}

	@GetMapping("/allComments")
	public List<TaskComments> getAllUserData() {

		return commentsService.getAllUsers();

	}
	
//	@GetMapping("/comments/task/{taskId}")
//	public List<TaskComments> getCommentsForTask(@PathVariable int taskId) {
//
//		return commentsService.getCommentsForTask(taskId);
//
//	}
	@GetMapping("/getAllComments/{taskId}")
	  public ResponseEntity<List<CommentResource>> getAllCommentByTask(@PathVariable("taskId") int taskId) {
//	    CommentResource dto = new CommentResource();
//	    dto.setComment(commentsService.getAllCommentByTask(taskId));
	    return new ResponseEntity<List<CommentResource>>(commentsService.getAllCommentByTask(taskId), HttpStatus.OK);
	  }
	
//	  @GetMapping("/{taskId}/comments")
//	    public ResponseEntity<List<String>> getCommentsByTaskId(@PathVariable int taskId) {
//	        List<String> commentTexts = commentsService.getCommentTextsByTaskId(taskId);
//	        return ResponseEntity.ok(commentTexts);
//	    }
	
//	@PutMapping("/task/{taskId}/comment/{taskCommentsID}")
//    public ResponseEntity<String> assignProjectToUser(@PathVariable int taskId, @PathVariable int taskCommentsID) {
//        commentsService.assignCommentToTask(taskId,taskCommentsID);
//        return ResponseEntity.noContent().build();
//    }
	
	@DeleteMapping("/deleteallComments")
	public void deleteAllComments(){
		commentsService.deleteAllComments();
	}
}
