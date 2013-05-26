package com.bharatonjava.jdbc.exceptions;

public class JdbcException extends RuntimeException {

	private static final long serialVersionUID = 5439915454935047936L;

	public JdbcException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage(){
		return super.getMessage();
	}
	
	
	@Override
	public Throwable  getCause() {
		return super.getCause();
	}
}
