package com.departmentservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * 
 * @author Haritha Nadimpalli
 *
 */
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(DepartmentNotFoundException exception, WebRequest webRequest) {
		ExceptionDetails response = new ExceptionDetails();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Department not found");
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(EmployeeNotFounException.class)
	public ResponseEntity<Object> handleExceptions(EmployeeNotFounException exception, WebRequest webRequest) {
		ExceptionDetails response = new ExceptionDetails();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Employee given was not found");
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
}
