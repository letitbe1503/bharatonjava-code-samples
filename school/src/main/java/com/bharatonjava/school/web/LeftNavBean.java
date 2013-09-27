package com.bharatonjava.school.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "leftNav")
@SessionScoped
public class LeftNavBean implements Serializable{

	private static final long serialVersionUID = -8840816314018634125L;

	private int accordionIndex;
	
	public int getAccordionIndex() {
		return accordionIndex;
	}
	
	public void setAccordionIndex(int accordionIndex) {
		this.accordionIndex = accordionIndex;
	}
	
}
