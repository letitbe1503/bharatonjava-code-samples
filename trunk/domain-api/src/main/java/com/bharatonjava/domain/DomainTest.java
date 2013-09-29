package com.bharatonjava.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DomainTest {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("domain-config.xml");
		
		DomainEntry entry = (DomainEntry) context.getBean("domainEntry");
		
		entry.getXmlforMap();
				
	}
}
