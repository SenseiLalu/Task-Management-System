package com.example.demo;

public class CustomExceptionHandler extends RuntimeException{
	
	public CustomExceptionHandler(String message) {
		super(message);
	}

}
