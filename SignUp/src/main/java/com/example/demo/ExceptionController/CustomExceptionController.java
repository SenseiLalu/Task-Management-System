package com.example.demo.ExceptionController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.CustomExceptionHandler;

@RestControllerAdvice
public class CustomExceptionController {

	@ExceptionHandler
	public ResponseEntity<ErrorInfo>customExceptionHandler(CustomExceptionHandler exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
