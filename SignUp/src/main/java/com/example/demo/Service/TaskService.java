package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.example.demo.CustomExceptionHandler;
import com.example.demo.DTOClasses.TaskDetailsDTO;
import com.example.demo.DTOClasses.TaskDetailsResponse;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskCategory;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.StatusRepository;
import com.example.demo.Repository.TaskCategoryRepository;
import com.example.demo.Repository.TaskCommentsRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TaskService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	TaskCommentsRepository commentsRepository;

	@Autowired
	TaskCategoryRepository categoryRepository;

	@Autowired
	ProjectRepository projectRepository;


	public Task addTaskDataToDB(TaskDetailsDTO detailsDTO) {
		Optional<Task> findById = Optional.ofNullable(taskRepository.findBytaskName(detailsDTO.getTaskName()));
		if (findById.isPresent()) {
			throw new CustomExceptionHandler("This Title belongs to another task !!");
		}
		Task details = new Task();
		Optional<TaskCategory> category = categoryRepository.findById(detailsDTO.getTaskCategoryId());
		Optional<User> createdby = userRepository.findById(detailsDTO.getCreatedby());
		Optional<User> assignedto = userRepository.findById(detailsDTO.getAssignedDto());
		Optional<Status> status = statusRepository.findById(detailsDTO.getStatusId());
		Optional<Project> project = projectRepository.findById(detailsDTO.getProjectId());

		details.setCategory(category.get());
		details.setTaskName(detailsDTO.getTaskName());
		details.setAssigenedDate(detailsDTO.getAssigenedDate());
		details.setCreatedby(createdby.get());
		details.setAssignedDto(assignedto.get());

		// logic for auto generated date
		Calendar calendar = Calendar.getInstance();
		details.setCreatedOn(calendar);

		details.setLongDescription(detailsDTO.getLongDescription());
		details.setDeuDate(detailsDTO.getDeuDate());
		details.setStatus(status.get());
		details.setProject(project.get());

		taskRepository.save(details);
		return details;

	}

	public Task getNameById(int taskId) {

		Optional<Task> byId = taskRepository.findById(taskId);
		Task task = byId.get();

		return task;
	}

	public Status getStatusById(int statusId) {

		Optional<Status> findById = statusRepository.findById(statusId);
		Status status = findById.get();
		return status;
	}

	public List<TaskDetailsDTO> getAllTaskDetails() {

		List<Task> findAll = (List<Task>) taskRepository.findAll();
		List<TaskDetailsDTO> dtos = new ArrayList<>();
		for (Task task : findAll) {
			TaskDetailsDTO dto = new TaskDetailsDTO();
			dto.setTaskId(task.getTaskId());
			dto.setTaskName(task.getTaskName());
			dto.setLongDescription(task.getLongDescription());
			dto.setAssigenedDate(task.getAssigenedDate());
			dto.setDeuDate(task.getDeuDate());
			dto.setStatusId(task.getStatus().getStatusId());
			dto.setAssignedDto(task.getAssignedDto().getUserId());
			dto.setCreatedby(task.getCreatedby().getUserId());
			dto.setCreatedOn(task.getCreatedOn());
			dto.setTaskCategoryId(task.getCategory().getTaskCategoryId());
			dto.setProjectId(task.getProject().getProjectId());
			dtos.add(dto);
		}

		return dtos;

	}


	public TaskDetailsResponse getTaskResponse(Task task) {

		TaskDetailsResponse taskResponse = new TaskDetailsResponse();
		taskResponse.setTaskName(task.getTaskName());
		taskResponse.setLongDescription(task.getLongDescription());
		taskResponse.setTaskCategoryDescription(task.getCategory());
		taskResponse.setAssigenedDate(task.getAssigenedDate());
		taskResponse.setAssignedDto(task.getAssignedDto());
		taskResponse.setCreatedBy(task.getCreatedby());
		taskResponse.setStatusId(task.getStatus());
		taskResponse.setTaskId(task.getTaskId());
		taskResponse.setCreatedOn(task.getCreatedOn());
		taskResponse.setDeuDate(task.getDeuDate());
		taskResponse.setProjectName(task.getProject());
		return taskResponse;
	}

	public Task getTask(int taskId) {
		return taskRepository.findById(taskId).orElseThrow(RuntimeException::new);
	}

	@Transactional
	public List<TaskDetailsResponse> getAllTask() {
		Iterable<Task> task = taskRepository.findAll();
		List<TaskDetailsResponse> taskResponses = new ArrayList<>();
		for (Task tasks : task) {

			taskResponses.add(getTaskResponse(tasks));
		}
		return taskResponses;
	}

	@Transactional
	public Task updateTask(TaskDetailsDTO detailsDTO, int taskId) {
		Task findById = taskRepository.findById(taskId).get();
		findById.setAssigenedDate(detailsDTO.getAssigenedDate());
		findById.setDeuDate(detailsDTO.getDeuDate());
		findById.setTaskName(detailsDTO.getTaskName());
//  findById.getAssignedto().setUserId(detailsDTO.getAssignedto());;
//	  findById.getStatus().setStatusId(detailsDTO.getStatusId());

		return taskRepository.save(findById);
	}

@Transactional
public Task updateTasks(TaskDetailsDTO dto, int taskId) {
	 Task task = taskRepository.findById(taskId).orElse(null);
	 
	 Status status = statusRepository.findById(dto.getStatusId()).orElse(null);
	 
	User user = userRepository.findById(dto.getAssignedDto()).orElse(null);

//	 Task task = new Task();
	  task.setTaskName(dto.getTaskName());
      task.setAssigenedDate(dto.getAssigenedDate());
      task.setDeuDate(dto.getDeuDate());
      task.setAssignedDto(user);
      task.setStatus(status);
     
      return  taskRepository.save(task);
//	Task task2 = new Task();
//	task2.setTaskName(task.getTaskName());
//	task2.setAssigenedDate(task.getAssigenedDate());
//	task2.setDeuDate(task.getDeuDate());
//	taskRepository.save(task2);
	
//	Status status2 = new Status();
//	status2.setDescription(status.get());
	
	 
}
}
