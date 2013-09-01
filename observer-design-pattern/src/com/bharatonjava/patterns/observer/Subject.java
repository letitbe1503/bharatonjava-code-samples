package com.bharatonjava.patterns.observer;

public interface Subject {

	public void registerObserver(Observer observer);
	
	public void unregisterObserver(Observer observer);
	
	public void notifyObserver();
	
	public Object getUpdate();
	
	public void setArticle(String article); 
	
}
