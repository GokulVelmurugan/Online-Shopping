package com.ideas2it.onlinestore.util.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.ideas2it.onlinestore.model.ErrorMessage;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(OnlineStoreException.class)
	public ResponseEntity<ErrorMessage> OnlineStoreException(OnlineStoreException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				ex.httpStatus.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		System.out.println("I am here");
		ErrorMessage message = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);	
		
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//		ErrorMessage message = new ErrorMessage(
//				HttpStatus.NOT_FOUND.value(),
//				new Date(),
//				ex.getMessage(),
//				request.getDescription(false));
//		
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//	}
	
//	@ExceptionHandler(BadCredentialsException.class)
//	public ResponseEntity<ErrorMessage> badCreditialsExceptionHandler(BadCredentialsException ex, WebRequest request) {
//		ErrorMessage message = new ErrorMessage(
//				HttpStatus.BAD_REQUEST.value(), 
//				new Date(), 
//				"Invalid Username/Password", 
//				request.getDescription(false));
//		
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);	
//		
//	}
	
//	@ExceptionHandler(ExpiredJwtException.class)
//	public ResponseEntity<ErrorMessage> expiredJwtTokenExceptionHandler(ExpiredJwtException ex, WebRequest request) {
//		ErrorMessage message = new ErrorMessage(
//				HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(), 
//				new Date(), 
//				"Expired JWT Token", 
//				request.getDescription(false));
//		
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);	
//		
//	}
}
