package com.bharatonjava.pms.web;

import java.io.Serializable;

import com.bharatonjava.pms.domain.User;
import com.bharatonjava.pms.util.Constants;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 9064636336219217155L;

	private String username;
	private String password;

	private User user;
	
	public UserBean() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String verifyUser() {
		System.out.println("verifyUser: " + username + " " + password);
		
		return Constants.VIEW_HOME_PAGE;
	}
}
