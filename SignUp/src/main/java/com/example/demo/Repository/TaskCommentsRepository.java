package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.TaskComments;

public interface TaskCommentsRepository extends CrudRepository<TaskComments, Integer>{

	
	
	
	//List<TaskComments> findByTaskId(int taskId);

}
