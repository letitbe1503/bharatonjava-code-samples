package com.bharatonjava.jdbc.exceptions;

public class JdbcConfigurationException extends Exception{

	private static final long serialVersionUID = -6168932787677919957L;

	public JdbcConfigurationException(String message) {
		super(message);
	}
	
	public JdbcConfigurationException(String message, Throwable cause){
		super(message, cause);
	}
}
