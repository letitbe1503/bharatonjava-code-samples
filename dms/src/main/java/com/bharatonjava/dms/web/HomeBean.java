package com.bharatonjava.dms.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean(name = "home")
@SessionScoped
public class HomeBean implements Serializable{
	
	private static final long serialVersionUID = -7836041718866300020L;

	private static final Log log = LogFactory.getLog(HomeBean.class);
	
	private String msg = "Hello Bharat";
	
	public String getMsg() {
		log.info("returning message.");
		return msg;
	}
}
