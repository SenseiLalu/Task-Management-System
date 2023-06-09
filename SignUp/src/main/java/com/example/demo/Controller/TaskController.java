package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOClasses.TaskDetailsDTO;
import com.example.demo.DTOClasses.TaskDetailsResponse;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskComments;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Service.TaskService;

import jakarta.transaction.Transactional;

@CrossOrigin
@RestController
public class TaskController {

	@Autowired
	TaskService taskservice;
	
	@Autowired
	TaskRepository repository;
	
	@Transactional
	@PostMapping("/addTask")
	public Task addTask(@RequestBody TaskDetailsDTO taskdto) {
		
		  Task taskDataToDB = taskservice.addTaskDataToDB(taskdto);
		
		return taskDataToDB;
	}
	
	
//	@GetMapping("/api/names/{taskId}/{statusId}")
//	public ResponseEntity<Map<String, String>> getNameById(@PathVariable int taskId, @PathVariable int statusId) {
//	     Task task = taskservice.getNameById(taskId);
//	     TaskDetailsDTO detailsDTO= new TaskDetailsDTO();
//	     Status status = taskservice.getStatusById(statusId);
//	    if (task == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//	    Map<String, String> result = new HashMap<>();
////	    result.put("id", String.valueOf(task.getTaskId()));
//	    result.put("name", task.getTaskName());
//	    result.put("status", status.getDescription());
//	 //   result.put("description",task.get);
//	    return ResponseEntity.ok(result);
//	}
	
	
	@GetMapping("/allTAskDetails")
	  public List<TaskDetailsDTO> getAllCityAndCountryNames() {
		 return  taskservice.getAllTaskDetails();
	
	   
	  }
	
	   @GetMapping("/getDetails/{taskId}")
	    public TaskDetailsResponse getTask(@PathVariable int taskId){
	        Task task= taskservice.getTask(taskId);
	        return taskservice.getTaskResponse(task);

	    }

	   @GetMapping("/getAllTaskData")
	    public List<TaskDetailsResponse> getAllTask(){
	        List<TaskDetailsResponse>  taskResponses= taskservice.getAllTask();
	        return taskResponses;
	    }
	
//	@GetMapping("/getAllTAskDetails")
//	  public List<TaskDetailsResponse> getAllTaskDetails() {
//		
//		TaskDetailsResponse detailsResponse = new TaskDetailsResponse();
//		//TaskDetailsDTO detailsDTO = taskservice.getAllTaskDetailsData();
//		List<TaskDetailsResponse> allTaskDetailsData = taskservice.getAllTaskDetailsData();
//		detailsResponse.setDescription(detailsResponse.getDescription());
//		 return allTaskDetailsData;
//	
//	   
//	  }
	
	@PutMapping("/update/{taskId}")
	public Task updateData(@RequestBody TaskDetailsDTO detailsDTO ,@PathVariable int taskId) {
		 Task updateTask = taskservice.updateTask(detailsDTO,taskId);
		return updateTask;
	}
//	
	@PutMapping("/updateTask/{taskId}")
	public Task updateTaskData(@RequestBody TaskDetailsDTO dto,@PathVariable int taskId) {
		 Task updateTask = taskservice.updateTasks(dto,taskId);
		return updateTask;
	}
	
	
//
//    @GetMapping("/projects/{taskId}")
//    public ResponseEntity<List<TaskComments>> getProjectsByTaskId(@PathVariable int taskId) {
//        List<TaskComments> comment = repository.findTaskCommentsByTaskId(taskId);
//        return new ResponseEntity<>(comment, HttpStatus.OK);
//    }
}












