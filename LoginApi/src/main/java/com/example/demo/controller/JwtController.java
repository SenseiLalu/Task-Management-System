package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.jwtHelper.JwtUtil;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		System.out.println(jwtRequest);

		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (UsernameNotFoundException e) {

			e.printStackTrace();
			throw new Exception("Bad credential");
		}

		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		User user = customUserDetailsService.getUserByEmail(jwtRequest.getUsername());
		// String token = this.jwtUtil.generateToken(userDetails);
		String token = this.jwtUtil.generateToken(userDetails, user.getEmail(), user.getRole());
		System.out.println("jwt" + token);

		return ResponseEntity.ok(new JwtResponse(token,user));
	}

	@GetMapping("/user")
	public String getUser(Authentication authentication) {

		return authentication.getName();
	}

	@GetMapping("/currentuser")
	public Map<String, String> getCurrentUser(Authentication authentication) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", authentication.getName());
		return userMap;
	}

//	@GetMapping("/currentuser")
//    public ResponseEntity<?> getUserDetails(HttpServletRequest request) {
//        String token = request.getHeader("Authorization").substring(7);
//        User user = customUserDetailsService.getUserFromToken(token);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.ok(user);
//    }
}
