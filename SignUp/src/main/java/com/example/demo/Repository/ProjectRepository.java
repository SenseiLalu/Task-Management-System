package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Project;

public interface ProjectRepository  extends CrudRepository<Project, Integer>{
	
	@Query("SELECT p.projectName FROM Project p")
	List<String> findAllProjectName();

	@Query("SELECT p.projectName FROM Project p WHERE p.projectId = :projectId")
	String findProjectNameByProjectId(@Param("projectId") int projectId); 
}
