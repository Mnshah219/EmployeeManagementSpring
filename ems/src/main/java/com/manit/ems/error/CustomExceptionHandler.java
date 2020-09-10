package com.manit.ems.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleAllCustomExceptions(Exception e, WebRequest request){
		CustomErrorResponse error = new CustomErrorResponse(e.getMessage());
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
