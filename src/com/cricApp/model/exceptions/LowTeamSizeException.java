package com.cricApp.model.exceptions;

public class LowTeamSizeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg  = "Min Team size is 2 " ; 
	
	public LowTeamSizeException() {
		
	}
	public LowTeamSizeException(String msg ) {
		this.msg= msg  ; 
	}
	public String getMessage() {
		return msg  ; 
	}
	
}
