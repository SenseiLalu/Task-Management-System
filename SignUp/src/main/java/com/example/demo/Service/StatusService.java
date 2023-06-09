package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOClasses.ProjectDTO;
import com.example.demo.DTOClasses.StatusDTO;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.User;
import com.example.demo.Repository.StatusRepository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

@Service
public class StatusService {
	
	@Autowired
	StatusRepository statusRepository;

	@Transactional
	public Status addStatusDataToDB(Status status) {

		Status saveStatus = statusRepository.save(status);
		
		return saveStatus;
	}

	public Status getStatusDataFromDB(int statusId) {

		Optional<Status> findById = statusRepository.findById(statusId);
		
		Status status = findById.get();
		return status;
	}



	public List<String> getAllDescriptionNames() {
		return statusRepository.findAllDescription();
	}

	
	
	
	
	public Status getStatusData(int statusId) {

		return  statusRepository.findById(statusId).orElseThrow(RuntimeException::new);
	}
	
	
	@Transactional
	public List<Status> getAllUsers() {

		return	(List<Status>) statusRepository.findAll();
		
		
	}
	
}
