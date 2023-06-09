package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOClasses.TaskCategoryDtoResponse;
import com.example.demo.DTOClasses.TaskDetailsDTO;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskCategory;
import com.example.demo.Repository.TaskCategoryRepository;

import jakarta.transaction.Transactional;
@Service
public class TaskCategoryService {

	@Autowired
	TaskCategoryRepository categoryRepository;
	
	@Transactional
	public TaskCategory addCategoryToDB(TaskCategory category) {

		TaskCategory taskCategory = categoryRepository.save(category);
		
		return taskCategory;
	}


	public List<String> getAllTaskCategoryDescriptionNames() {

		
		return categoryRepository.findAllTaskCategoryDescription();
	}
@Transactional
	public List<TaskCategoryDtoResponse> getAllUsers() {

		 List<TaskCategory> findAll = (List<TaskCategory>) categoryRepository.findAll();
		 List<TaskCategoryDtoResponse> dtos = new ArrayList<>();
	     for (TaskCategory task : findAll) {
	         TaskCategoryDtoResponse dto = new TaskCategoryDtoResponse();
	         dto.setTaskCategoryId(task.getTaskCategoryId());
	         dto.setTaskCategoryDescription(task.getTaskCategoryDescription());
	         dtos.add(dto);
	}
	     return dtos;
}
}
