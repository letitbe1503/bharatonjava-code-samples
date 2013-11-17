package com.bharatonjava.pms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTIES")
public class Property {

	private Long propertyId;
	private String propertyAddress;
	private String ownerName;
	private String ownerPermanentAddress;
	private String ownerMobileNo;
	private String ownerLandlineNo;
	private String ownerEmail;
	private Double expectedRent;
	
	public Property() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROPERTY_ID")
	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	@Column(name = "PROPERTY_ADDRESS")
	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "OWNER_PERMANENT_ADDRESS")
	public String getOwnerPermanentAddress() {
		return ownerPermanentAddress;
	}

	public void setOwnerPermanentAddress(String ownerPermanentAddress) {
		this.ownerPermanentAddress = ownerPermanentAddress;
	}

	@Column(name = "PROPERTY_MOBILE")
	public String getOwnerMobileNo() {
		return ownerMobileNo;
	}

	public void setOwnerMobileNo(String ownerMobileNo) {
		this.ownerMobileNo = ownerMobileNo;
	}

	@Column(name = "OWNER_LANDLINE")
	public String getOwnerLandlineNo() {
		return ownerLandlineNo;
	}

	public void setOwnerLandlineNo(String ownerLandlineNo) {
		this.ownerLandlineNo = ownerLandlineNo;
	}

	@Column(name = "OWNER_EMAIL")
	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	@Column(name = "EXPECTED_RENT")
	public Double getExpectedRent() {
		return expectedRent;
	}

	public void setExpectedRent(Double expectedRent) {
		this.expectedRent = expectedRent;
	}
	
	
}
