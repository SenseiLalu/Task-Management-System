package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOClasses.ProjectDTO;
import com.example.demo.DTOClasses.StatusDtoResponse;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.User;
import com.example.demo.Service.StatusService;
@CrossOrigin
@RestController
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	@PostMapping("/addStatus") 
	public Status addStatus(@RequestBody Status status) {
		
		Status statusDataToDB = statusService.addStatusDataToDB(status);
		
		return statusDataToDB;
	}
	
//	@GetMapping("/getStatus/{statusId}")
//	public Status getStatus(@PathVariable int statusId) {
//		
//		Status statusDataFromDB = statusService.getStatusDataFromDB(statusId);
//		return statusDataFromDB;
//	}
//	
	@GetMapping("/getStatus/{statusId}")
	public StatusDtoResponse getStatus(@PathVariable int statusId)  {
		
		StatusDtoResponse dtoResponse = new StatusDtoResponse();
		Status status = statusService.getStatusData(statusId);
		dtoResponse.setStatusId(status.getStatusId());
		dtoResponse.setDescription(status.getDescription());
		System.out.println(".........");
		return dtoResponse;
	}
	
	@GetMapping("/getDescriptionName")
	public List<String> getAllData() {
		
		return statusService.getAllDescriptionNames();
		
	}
	
	@GetMapping("/getAllStatus")
	public List<Status> getAllStatusData() {
		
		return statusService.getAllUsers();
		
	}
	

}
