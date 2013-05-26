package com.bharatonjava.jdbc.exceptions;

public class EmptyResultsetException extends JdbcException{

	private static final long serialVersionUID = 4887429379842990615L;

	public EmptyResultsetException(String message) {
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
