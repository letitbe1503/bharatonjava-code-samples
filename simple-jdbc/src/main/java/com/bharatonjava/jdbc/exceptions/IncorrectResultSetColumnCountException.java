package com.bharatonjava.jdbc.exceptions;

public class IncorrectResultSetColumnCountException extends RuntimeException{

	private static final long serialVersionUID = 766100661831610565L;
	
	private int expectedCount;
	private int actualCount;

	public IncorrectResultSetColumnCountException(String message) {
		super(message);
	}
	
	public IncorrectResultSetColumnCountException(String message, int expectedCount, int acutalCount) {
		super(message);
		this.expectedCount = expectedCount;
		this.actualCount = actualCount;
	}
	
	@Override
	public String getMessage(){
		return super.getMessage();
	}
	
	@Override
	public Throwable  getCause() {
		return super.getCause();
	}
	
	public int getActualCount() {
		return actualCount;
	}
	
	public int getExpectedCount() {
		return expectedCount;
	}
}
