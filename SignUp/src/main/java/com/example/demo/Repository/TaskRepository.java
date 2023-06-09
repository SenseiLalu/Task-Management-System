package com.example.demo.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskComments;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	public Task findBytaskName(String taskName);
	
//	@Query("SELECT c.description AS description, co.username AS username FROM Task p JOIN p.status c JOIN p.user co")
//	List<Map<String,String>>findAllDescriptionAndUserNames();

	
//	@Query("SELECT taskCategory.taskCategoryDescription FROM Task t  INNER JOIN taskCategory ON t.taskCategory=taskCategory.taskCategoryId ")
//	List<Task> findAlltask();
	
//	 @Query("SELECT p FROM TaskComments p.tasks t WHERE t.id = :taskId")
//	   public List<TaskComments> findTaskCommentsByTaskId(@Param("taskId") int taskId);
	}
