package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.TaskCategory;

public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Integer> {

	@Query("SELECT tc.taskCategoryDescription FROM TaskCategory tc")
	List<String> findAllTaskCategoryDescription();
	
}
