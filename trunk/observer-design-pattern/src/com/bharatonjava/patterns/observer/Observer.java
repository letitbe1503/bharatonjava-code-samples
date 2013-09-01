package com.bharatonjava.patterns.observer;

public interface Observer {

	public void update(Subject blog);
	
	public void setSubject(Subject subject);
}
