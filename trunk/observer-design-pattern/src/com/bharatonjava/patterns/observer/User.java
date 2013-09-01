package com.bharatonjava.patterns.observer;

public class User implements Observer{

	private String article;
	private Subject blog;
	
	
	
	@Override
	public void update(Subject blog) {
		this.blog = blog;
		article = (String) this.blog.getUpdate();
		System.out.println("user recieved updated article:: "+ article);
	}

	@Override
	public void setSubject(Subject blog) {
		System.out.println("state change reported by subject");
		this.blog = blog;
		
	}
	
}
