package com.ideas2it.onlinestore.util.customException;

import org.springframework.http.HttpStatus;

/**
 * This class is used to convert all message to custom exception
 *
 * @version 1.0
 * @author arunkumar			
 */
public class OnlineStoreException extends Exception {

	public HttpStatus httpStatus;
	
	public OnlineStoreException(String message) {
		super(message);
	}
	
	public OnlineStoreException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
}
