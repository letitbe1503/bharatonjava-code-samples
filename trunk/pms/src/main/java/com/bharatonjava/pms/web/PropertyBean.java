package com.bharatonjava.pms.web;

import java.io.Serializable;

import com.bharatonjava.pms.domain.Property;

public class PropertyBean implements Serializable{
	
	private static final long serialVersionUID = 576183534214799659L;
	
	private Property property = new Property();
	
	public PropertyBean() {
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
}
