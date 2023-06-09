package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOClasses.TaskDetailsDTO;
import com.example.demo.DTOClasses.TaskListResources;
import com.example.demo.Entity.CommentUserTask;
import com.example.demo.Repository.CommentTaskUserRepo;

@Service
public class CommentTaskUserService {
	
	
	@Autowired
	CommentTaskUserRepo commentTaskUserRepo;

	public CommentUserTask commentTaskUser(CommentUserTask commentUserTask) {
CommentUserTask save = commentTaskUserRepo.save(commentUserTask);
		
		return save;
	}

//	
//	public List<TaskListResources> getAllProjectByUser(int taskId) {
//		 List<TaskListResources> collect = commentTaskUserRepo.findById((long) taskId)
//				 .get()
//				 .getComment()
//               .stream()
//               .map(comment -> new TaskDetailsDTO(comment))
//               .collect(Collectors.toList());
//		 return collect;
//	}
}
