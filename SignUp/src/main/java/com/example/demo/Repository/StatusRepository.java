package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {

	@Query("SELECT s.description FROM Status s")
	List<String> findAllDescription();
	
}
