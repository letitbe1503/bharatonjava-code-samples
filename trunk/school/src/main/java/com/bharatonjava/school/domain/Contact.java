package com.bharatonjava.school.domain;

public class Contact {

	private Long contactId;
	private String building;
	private String street;
	private String area;
	private String city;
	private String state;
	
	private Long phoneNumber;
	private Long alternatePhoneNumber;
	private String email;
	
	public Contact() {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(Long alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", building=" + building
				+ ", street=" + street + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", phoneNumber=" + phoneNumber
				+ ", alternatePhoneNumber=" + alternatePhoneNumber + ", email="
				+ email + "]";
	}
	
}
