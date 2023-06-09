package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOClasses.TaskCategoryDtoResponse;
import com.example.demo.Entity.TaskCategory;
import com.example.demo.Service.TaskCategoryService;
@CrossOrigin
@RestController
public class TaskCategoryController {

	@Autowired
	TaskCategoryService categoryService;
	
	@PostMapping("/addCategory")
	public TaskCategory addCategory(@RequestBody TaskCategory category) {
		
		TaskCategory taskCategory = categoryService.addCategoryToDB(category);
		
		return taskCategory;
	}
	
	@GetMapping("/getTaskCategoryDescriptionName")
	public List<String> getAllData() {
		
		return categoryService.getAllTaskCategoryDescriptionNames();
		
	}
	
	@GetMapping("/getAllCategory")
	public List<TaskCategoryDtoResponse> getAllUserData() {
		
		return categoryService.getAllUsers();
		
	}
}
