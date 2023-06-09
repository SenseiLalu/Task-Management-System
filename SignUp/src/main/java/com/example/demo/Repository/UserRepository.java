package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	//@Query("SELECT u.username FROM User u")
	//List<String> findAllUsername();
	
}
