package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/insertUser")
	public User addDataToDb(@RequestBody User user) {
//		String encode = bCryptPasswordEncoder.encode(user.getPassword());
//		user.setPassword(encode);
		User save = repository.save(user);
		return save;
	}
}
