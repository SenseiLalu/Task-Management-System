package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOClasses.TaskListResources;
import com.example.demo.Entity.CommentUserTask;
import com.example.demo.Service.CommentTaskUserService;

@RestController
public class CommentTaskUserController {

	
	@Autowired
	CommentTaskUserService commentTaskUserService;
	
	
	
	@PostMapping("/userTaskComment")
    public ResponseEntity<CommentUserTask> createUserTaskComment(@RequestBody CommentUserTask commentUserTask ) {
		CommentUserTask savedUserTaskProject = commentTaskUserService.commentTaskUser(commentUserTask);
        return new ResponseEntity<>(savedUserTaskProject, HttpStatus.CREATED);
    }
	
	
//	@GetMapping("/getAllCommentsByTaskId/{taskId}")
//	  public ResponseEntity<TaskListResources> getAllCommentsByTaskId(@PathVariable("taskId") int taskId) {
//		TaskListResources dto = new TaskListResources();
//	    dto.setTaskList(commentTaskUserService.getAllProjectByUser(taskId));
//	    return new ResponseEntity<TaskListResources>(dto, HttpStatus.OK);
//	  }
	
	
	
}
