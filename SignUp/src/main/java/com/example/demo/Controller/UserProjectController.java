package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTOClasses.UserProjectResponse;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.UserRepository;
@CrossOrigin
@RestController
public class UserProjectController {
@Autowired
	UserRepository repository;
	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("/projects-users")
	  public ResponseEntity<List<UserProjectResponse>> getAllProjectsAndUsers() {
	    List<UserProjectResponse> projectUserDTOs = new ArrayList<>();
	    
	    List<Project> projects = (List<Project>) projectRepository.findAll();
	    
	    for (Project project : projects) {
	      for (User user : project.getUsers()) {
	        UserProjectResponse projectUserDTO = new UserProjectResponse(project.getProjectName(), user.getUsername());
	        projectUserDTOs.add(projectUserDTO);
	      }
	    }
	    
	    return ResponseEntity.ok(projectUserDTOs);
	  }
	
}
