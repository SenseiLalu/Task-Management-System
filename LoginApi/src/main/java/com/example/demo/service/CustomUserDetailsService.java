package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomeUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
//	@Autowired
//	JwtUtil jwtUtil;
//	
//	@Autowired
//	CustomeUserDetails customeUserDetails;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		com.example.demo.entity.User user = this.repository.findByUsername(username);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User Not Found!!");
		}else {
			return new CustomeUserDetails(user);
		}
		
		
	
		
	}
	
	 public User getUserByEmail(String username){
	        return repository.findByUsername(username);
	    }
	
	
	

}
