package com.bharatonjava.jdbc.client;

public class Contact {

	private Long contactId;
	private String building;

	public Contact() {
	}
	
	public Contact(Long contactId, String building) {
		super();
		this.contactId = contactId;
		this.building = building;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", building=" + building
				+ "]";
	}

}
