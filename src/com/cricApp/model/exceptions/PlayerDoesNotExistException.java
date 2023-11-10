package com.cricApp.model.exceptions;

public class PlayerDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message  = "Player Name Not Found" ; 
	
	public PlayerDoesNotExistException() {
		
	}
	
	public PlayerDoesNotExistException(String message) {
		this.message = message ; 
	}
	
	public String getMessage() {
		return message ; 
	}
}
