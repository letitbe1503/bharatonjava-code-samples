package com.bharatonjava.school.dao;

import java.util.List;

import com.bharatonjava.school.domain.Contact;

public interface ContactDao {

	public int saveContact(Contact contact);
	
	public int deleteContact(Long contactId);
	
	public int updateContact(Contact contact);
	
	public Contact getContactById(Long contactId);
	
	public List<Contact> getAllContacts();
}
