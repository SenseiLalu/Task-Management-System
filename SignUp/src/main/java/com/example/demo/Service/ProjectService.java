package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOClasses.ProjectDTO;
import com.example.demo.DTOClasses.UserProjectDTO;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.UserRepository;
@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Project addProjectToDB(Project project) {

		Project saveProject = projectRepository.save(project);
		
		return saveProject;
	}


	public List<String> getAllProjectNames() {
		 return projectRepository.findAllProjectName();

	}


	public String getNameById(int projectId) {

		return projectRepository.findProjectNameByProjectId(projectId);
	}


	public List<Project> getAllProjectData() {

		 return (List<Project>) projectRepository.findAll();
		 
	
		
	}


	public Project deleteDataFromTable(Project project) {

		 projectRepository.deleteAll();
		 
		 return null;
		
	}


	 public String assignProjectToUser(int projectId, int userId) {
	        Project project = projectRepository.findById(projectId).orElseThrow();
	        User user = userRepository.findById(userId).orElseThrow();

	        project.getUsers().add(user);
	        projectRepository.save(project);

	        user.getProjects().add(project);
	        userRepository.save(user);
	        
	        return "user"+userId+ "Assign to project"+projectId;
	    }


//	public Project addProjectAndUserDataToDB(UserProjectDTO projectDTO) {
//
//		Project project2= new Project();
//		 Optional<Project> findById2 = projectRepository.findById(projectDTO.getProjectId());
//		Optional<User> findById = userRepository.findById(projectDTO.getProjectId());
//		project2.setUsers(findById.get());	
//		return null;
//	}
	
}
