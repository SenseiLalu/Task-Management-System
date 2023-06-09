package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.CommentUserTask;

public interface CommentTaskUserRepo extends CrudRepository<CommentUserTask, Integer> {

}
