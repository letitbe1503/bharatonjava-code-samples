package com.bharatonjava.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	boolean isUpdated;

	// blog data
	String article = "this is some article posted on blog";

	
	
	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
		System.out.println("Observer registered.");
	}

	@Override
	public void unregisterObserver(Observer observer) {
		int index = this.observers.indexOf(observer);
		if (index > 0) {
			this.observers.remove(index);
		}
	}

	@Override
	public void notifyObserver() {
		if (isUpdated) {
			for (Observer o : observers) {
				o.update(this);
			}
		}

		isUpdated = false;
	}

	@Override
	public Object getUpdate() {

		return article;
	}
	
	public void setArticle(String article) {
		this.article = article;
		this.isUpdated = true;
		System.out.println("blog updated.");
		notifyObserver();
	}

}
