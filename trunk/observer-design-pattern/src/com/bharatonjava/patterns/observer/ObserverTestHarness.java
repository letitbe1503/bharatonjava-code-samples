package com.bharatonjava.patterns.observer;

public class ObserverTestHarness {

	public static void main(String[] args){
		Subject blog = new Blog();
		
		Observer user = new User();
		blog.registerObserver(user);
		
		blog.setArticle("updated article");
	}
}
