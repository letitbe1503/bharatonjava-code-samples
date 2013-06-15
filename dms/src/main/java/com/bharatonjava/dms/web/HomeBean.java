package com.bharatonjava.dms.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "home")
@SessionScoped
public class HomeBean {

	private String msg = "Hello Bharat";
	
	public String getMsg() {
		return msg;
	}
}
