package com.example.demo.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOClasses.TaskCommentDTO;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TaskComments;
import com.example.demo.Entity.User;
import com.example.demo.Repository.TaskCommentsRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.resource.CommentResource;

import jakarta.transaction.Transactional;

@Service
public class TaskCommentsService {

	@Autowired
	TaskCommentsRepository commentsRepository;

	@Autowired
	TaskRepository repository;
	
	@Autowired 
	UserRepository userRepository;

	public TaskComments addCommentsToDB(TaskCommentDTO taskCommentsDto) {

		Optional<TaskComments> findById = commentsRepository.findById(taskCommentsDto.getTaskCommentsID());
		TaskComments comments = new TaskComments();
		Optional<Task> task = repository.findById(taskCommentsDto.getTaskId());
		Optional<User> user = userRepository.findById(taskCommentsDto.getUserId());
		comments.setComment(taskCommentsDto.getComment());
		Calendar calendar = Calendar.getInstance();
		comments.setCommentDateAndTime(calendar);
		comments.setTask(task.get());
		comments.setUser(user.get());
		commentsRepository.save(comments);
		return comments;
	}
	
	
//	public List<String> getCommentTextsByTaskId(int taskId) {
//        return commentsRepository.findByTaskId(taskId);
//    }

	@Transactional
	public List<TaskComments> getAllUsers() {

		return (List<TaskComments>) commentsRepository.findAll();

	}

//	public List<TaskComments> getCommentsForTask(int taskId) {
//
//		return	(List<TaskComments>) commentsRepository.findByTaskId(taskId);
//		
//		
//	}

//	public void assignCommentToTask(int taskId, int taskCommentsID) {
//		Task task = repository.findById(taskId).orElse(null);
//		TaskComments comment = commentsRepository.findById(taskCommentsID).orElse(null);
//
//		task.getComment().add(comment);
//		repository.save(task);
//
//		comment.getTask().add(task);
//		commentsRepository.save(comment);
//
//	}

	public List<CommentResource> getAllCommentByTask(int taskId) {
		List<CommentResource> collect = repository.findById(taskId).get().getComment().stream()
				.map(comment -> new CommentResource(comment)).collect(Collectors.toList());
		return collect;
	}
	
	
	public void deleteAllComments(){
		 commentsRepository.deleteAll();
		
	}
}
