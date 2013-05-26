package com.bharatonjava.jdbc.exceptions;

public class IncorrectResultsetSizeException extends JdbcException{

	private static final long serialVersionUID = 4887429379842990615L;

	public IncorrectResultsetSizeException(String message) {
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
